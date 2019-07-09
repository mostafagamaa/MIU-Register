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

public class StudentActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_screen);
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        TextView welc=findViewById(R.id.Name);
        welc.append(prefs.getString("username", "empty"));

        DataBase db = new DataBase(this);
        int us=prefs.getInt("us_id", 0);
        int st_id=db.get_Student(us);
        String arr[];
        arr=db.get_exam_date_time(st_id);
        TextView eng_exam_date=findViewById(R.id.eng_exam_date);
        eng_exam_date.append(arr[0]);
        TextView eng_exam_time=findViewById(R.id.eng_exam_time);
        eng_exam_time.append(arr[1]);
        TextView aptitude_exam_date=findViewById(R.id.ap_exam_date);
        aptitude_exam_date.append(arr[2]);
        TextView aptitude_exam_time=findViewById(R.id.ap_exam_time);
        aptitude_exam_time.append(arr[3]);

    }
    public void logout(View v){
        Intent iHel = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(iHel);
    }
}

