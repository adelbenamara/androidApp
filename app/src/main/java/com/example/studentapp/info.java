package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class info extends AppCompatActivity {
    private TextView title ;
    private ImageView btnhis ;
    private ImageView btnuser ;
    private ImageView btnhome ;
    private ImageView btninfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        title = findViewById(R.id.titelmenu);
        title.setText("About");


        btnuser = findViewById(R.id.userbtn);
        btnhis = findViewById(R.id.historybtn);
        btnhome = findViewById(R.id.menubtn);
        btninfo = findViewById(R.id.infobtn);


        btnhome.setImageResource(R.drawable.home_simple);
        btninfo.setImageResource(R.drawable.info_selected);
        btnhis.setImageResource(R.drawable.hist);
        btnuser.setImageResource(R.drawable.user);




        btnhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent histIntent = new Intent(info.this,history.class);
                startActivity(histIntent);
                finish(); }
        });

        //

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(info.this,HomeActivity.class);
                startActivity(infoIntent);
                finish(); }
        });

        //

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(info.this,user.class);
                startActivity(infoIntent);
                finish(); }
        });

        //
    }
}