package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    SharedPreferences sharedpref;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);
        TextView name= findViewById(R.id.textView4);
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        name.append(prefs.getString("username", "empty"));
    }
    public void onButtonClick1(View v) {
        Intent iHel = new Intent(getApplicationContext(), ViewApplicationsActivity.class);
        startActivity(iHel);
    }
    public void onButtonClick2(View v) {
        Intent iHel = new Intent(getApplicationContext(), DeleteApplicationsActivity.class);
        startActivity(iHel);
    }
    public void onButtonClicklogout(View v) {
        Intent iHel = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(iHel);
    }
}