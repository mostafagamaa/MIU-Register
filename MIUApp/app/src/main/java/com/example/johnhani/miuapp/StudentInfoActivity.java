package com.example.johnhani.miuapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class StudentInfoActivity extends AppCompatActivity {
    private TextView dateText;
    private EditText Fname;
    private EditText Mname;
    private EditText Lname;
    private EditText NationalId;
    private EditText FnameArab;
    private EditText MnameArab;
    private EditText Lnamearab;
    private Spinner Nationality;
    private Spinner Gender;
    private Spinner PlaceOfBirth;
    private Spinner Religion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        Fname=findViewById(R.id.fname);
        Mname=findViewById(R.id.mname);
        Lname=findViewById(R.id.lname);
        Nationality = (Spinner) findViewById(R.id.spiner);
        Gender = (Spinner) findViewById(R.id.spiner1);
        PlaceOfBirth = (Spinner) findViewById(R.id.spiner2);
        Religion = (Spinner) findViewById(R.id.spiner3);
        NationalId=findViewById(R.id.nationalID);
        FnameArab=findViewById(R.id.fnamearab);
        MnameArab=findViewById(R.id.mnamearab);
        Lnamearab=findViewById(R.id.lnamearab);

        dateText = findViewById(R.id.date_text_view);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        dateText.setText(day + "/" + (month+1) + "/" + year);

    }
    public void onButtonClick2(View v) {
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("fname", String.valueOf(Fname.getText()));
        editor.putString("mname", String.valueOf(Mname.getText()));
        editor.putString("lname", String.valueOf(Lname.getText()));
        editor.putString("fnamearabic", String.valueOf(FnameArab.getText()));
        editor.putString("mnamearabic", String.valueOf(MnameArab.getText()));
        editor.putString("lnamearabic", String.valueOf(Lnamearab.getText()));
        editor.putString("nationalid", String.valueOf(NationalId.getText()));
        editor.putString("dob", String.valueOf(dateText.getText()));
        editor.putString("nationality", Nationality.getSelectedItem().toString());
        editor.putString("gender", Gender.getSelectedItem().toString());
        editor.putString("religion", Religion.getSelectedItem().toString());
        editor.putString("pob", PlaceOfBirth.getSelectedItem().toString());
        editor.apply();
        Intent iHel = new Intent(getApplicationContext(), ContactInfoActivity.class);
        startActivity(iHel);
    }
    public void selectDate(View view) {


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);


        DatePickerDialog dialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                dateText.setText(day + "/" + (month + 1) + "/" + year);
            }
        },
                year, month, day);
        dialog.show();

    }

}

