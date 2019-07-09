package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signin=findViewById(R.id.signinbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });
        Button apply=findViewById(R.id.applybtn);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                startActivity(myIntent);
            }
        });

    }

    public void onButtonClick1(View v) {

        Intent iContact = new Intent(getApplicationContext(), weather.class);
        startActivity(iContact);
    }
    public void onButtonClick3(View v) {
        Intent iContact = new Intent(getApplicationContext(), ContactUsActivity.class);
        startActivity(iContact);
    }
    public void onButtonClick2(View v) {

        Intent iContact = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(iContact);
    }

}
