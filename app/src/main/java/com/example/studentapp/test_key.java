package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class test_key extends AppCompatActivity {
   private TextView key ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_key);
        key = findViewById(R.id.keys);
        HtmlParser htmlParser = new HtmlParser(this,key);
        htmlParser.parseHtml(R.raw.letremotive);

    }
}