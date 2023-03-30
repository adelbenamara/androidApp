package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity  {
    private TextView title ;
   private SearchView searchView ;
    private ListView listView ;
    private  ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter ;
    private ImageView btninfo ;
    private ImageView btnhis ;
    private ImageView btnuser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
        setContentView(R.layout.activity_home);
        title = findViewById(R.id.titelmenu);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listview);
        btninfo = findViewById(R.id.infobtn);
        btnuser = findViewById(R.id.userbtn);
        btnhis = findViewById(R.id.historybtn);

        title.setText("Home");




        //
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(HomeActivity.this,info.class);
                startActivity(infoIntent);
                finish(); }
        });


        btnhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent histIntent = new Intent(HomeActivity.this,history.class);
                startActivity(histIntent);
                finish(); }
        });

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(HomeActivity.this,user.class);
                startActivity(userIntent);
                finish(); }
        });

        arrayList = new ArrayList<>() ;
        arrayList.add("Lettre de motivation");
        arrayList.add("Education certificate");
        arrayList.add("Relevés de notes");
        arrayList.add("Attestation d’abondant");
        arrayList.add("Diplôme");
        arrayList.add("Group change");
        arrayList.add("Lettre de motivation");
        arrayList.add("Education certificate");
        arrayList.add("Relevés de notes");
        arrayList.add("Attestation d’abondant");
        arrayList.add("Diplôme");
        arrayList.add("Group change");
        arrayList.add("Lettre de motivation");
        arrayList.add("Education certificate");
        arrayList.add("Relevés de notes");
        arrayList.add("Attestation d’abondant");
        arrayList.add("Diplôme");
        arrayList.add("Group change");
        adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ( i == 0 ){
                    Intent intent = new Intent(HomeActivity.this,form_key.class);
                    startActivity(intent);
                }
                if ( i == 1){
                    Intent intent2 = new Intent(HomeActivity.this,test_key.class);
                    startActivity(intent2);
                }
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }


    }
