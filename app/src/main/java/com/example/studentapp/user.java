package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class user extends AppCompatActivity {

    private TextView title ;
    private ImageView btnhis ;
    private ImageView btnhome ;
    private ImageView btninfo ;
    private ImageView btnuser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        title = findViewById(R.id.titelmenu);
        title.setText("User");

        btnuser = findViewById(R.id.userbtn);
        btninfo = findViewById(R.id.infobtn);
        btnhome = findViewById(R.id.menubtn);
        btnhis = findViewById(R.id.historybtn);
        //

        btnhome.setImageResource(R.drawable.home_simple);
        btninfo.setImageResource(R.drawable.info);
        btnhis.setImageResource(R.drawable.hist);
        btnuser.setImageResource(R.drawable.user_selected);




        //
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(user.this,info.class);
                startActivity(infoIntent);
                finish(); }
        });


        btnhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent histIntent = new Intent(user.this,history.class);
                startActivity(histIntent);
                finish(); }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(user.this,HomeActivity.class);
                startActivity(userIntent);
                finish(); }
        });




    }
}