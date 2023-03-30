package com.example.studentapp;



import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HtmlParser {

    private Context context;
    private SharedPreferences preferences;
    private LinearLayout layout;

    public HtmlParser(Context context, LinearLayout layout) {
        this.context = context;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.layout = layout;
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

                    // create layout for the key and add TextView and EditText
                    LayoutInflater inflater = LayoutInflater.from(context);
                    View keyLayout = inflater.inflate(R.layout.key_layout, null);
                    TextView keyTextView = keyLayout.findViewById(R.id.keyTextView);
                    EditText keyEditText = keyLayout.findViewById(R.id.keyEditText);
                    keyTextView.setText(key);
                    layout.addView(keyLayout);
                }
            }
            Button submitButton = new Button(this.context);
            submitButton.setText("Submit");
            layout.addView(submitButton);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });



            reader.close();
            inputStream.close();

        } catch (IOException e) {
            Log.e("HtmlParser", "Error parsing HTML file: " + e.getMessage());
        }
    }

    public Map<String, String> getValues() {
        Map<String, String> values = new HashMap<>();
        for (String key : preferences.getAll().keySet()) {
            String value = preferences.getString(key, "");
            values.put(key, value);
        }
        return values;
    }

    public void saveValues(Map<String, String> values) {
        SharedPreferences.Editor editor = preferences.edit();
        for (String key : values.keySet()) {
            String value = values.get(key);
            editor.putString(key, value);
        }
        editor.apply();
    }
}
