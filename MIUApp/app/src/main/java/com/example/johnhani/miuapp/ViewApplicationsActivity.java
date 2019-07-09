package com.example.johnhani.miuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewApplicationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_applications);
        DataBase db = new DataBase(this);
        ArrayList<String[]> student=db.getStudents();
        ListView list = findViewById(R.id.listview);
        int x=0;
        String[] items=new String[student.size()];
        do {
            String[] st = student.get(x);
            items[x]=st[0]+"                   "+st[1];
            x++;
        }while (student.size()>x);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,items
        );
        list.setAdapter(adapter);

    }
    public void onButtonClickback(View v) {
        Intent iHel = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(iHel);
    }
   }