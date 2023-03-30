package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class form_key extends AppCompatActivity {
    private HtmlParser htmlParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_key);
        LinearLayout layout = findViewById(R.id.form_layout);
        htmlParser = new HtmlParser(this, layout);
        htmlParser.parseHtml(R.raw.letremotive);


    }
}