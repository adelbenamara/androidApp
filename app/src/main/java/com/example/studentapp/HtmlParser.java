package com.example.studentapp;



import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HtmlParser {

    private Context context;
    private SharedPreferences preferences;
    private TextView textView;

    public HtmlParser(Context context, TextView textView) {
        this.context = context;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.textView = textView;
    }

    public void parseHtml(int resourceId) {
        try {
            InputStream inputStream = context.getResources().openRawResource(resourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("@key{")) {
                    String key = line.substring(line.indexOf("@key{") + 5, line.indexOf("}"));
                    preferences.edit().putString(key, "empty").apply();
                }
            }

            reader.close();
            inputStream.close();

            // show keys in the TextView
            StringBuilder stringBuilder = new StringBuilder();
            for (String key : preferences.getAll().keySet()) {
                stringBuilder.append(key).append('\n');
            }
            textView.setText(stringBuilder.toString());

        } catch (IOException e) {
            Log.e("HtmlParser", "Error parsing HTML file: " + e.getMessage());
        }
    }
}
