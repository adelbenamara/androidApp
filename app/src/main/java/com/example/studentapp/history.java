package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class history extends AppCompatActivity {
    private TextView title ;
    private ImageView btnhis ;
    private ImageView btnhome ;
    private ImageView btninfo ;
    private ImageView btnuser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        title = findViewById(R.id.titelmenu);
        title.setText("History");

        btnuser = findViewById(R.id.userbtn);
        btninfo = findViewById(R.id.infobtn);
        btnhome = findViewById(R.id.menubtn);
        btnhis = findViewById(R.id.historybtn);
        //

        btnhome.setImageResource(R.drawable.home_simple);
        btninfo.setImageResource(R.drawable.info);
        btnhis.setImageResource(R.drawable.hist_selected);
        btnuser.setImageResource(R.drawable.user);





        //
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(history.this,user.class);
                startActivity(userIntent);
                finish(); }
        });


        //
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(history.this,info.class);
                startActivity(infoIntent);
                finish(); }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(history.this,HomeActivity.class);
                startActivity(infoIntent);
                finish(); }
        });


    }
}