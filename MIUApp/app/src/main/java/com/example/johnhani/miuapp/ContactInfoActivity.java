package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class ContactInfoActivity extends AppCompatActivity {
    private EditText Buildingno;
    private EditText Studentmobile;
    private EditText Email;
    private EditText Homephone;
    private EditText AddressArabic;
    private EditText Pobox;
    private Spinner Country;
    private Spinner City;
    private Spinner Area;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_information);
        Buildingno=findViewById(R.id.bn);
        Country= (Spinner) findViewById(R.id.spiner);
        City = (Spinner) findViewById(R.id.spiner2);
        Area = (Spinner) findViewById(R.id.spiner3);
        Studentmobile=findViewById(R.id.studmo);
        Email=findViewById(R.id.email);
        Homephone=findViewById(R.id.homphone);
        AddressArabic=findViewById(R.id.address);
        Pobox=findViewById(R.id.box);

    }
    public void onButtonClick3(View v) {
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("buildingno", String.valueOf(Buildingno.getText()));
        editor.putString("studentmobileno", String.valueOf(Studentmobile.getText()));
        editor.putString("email", String.valueOf(Email.getText()));
        editor.putString("studentphoneno", String.valueOf(Homephone.getText()));
        editor.putString("arabicaddress", String.valueOf(AddressArabic.getText()));
        editor.putString("pobox", String.valueOf(Pobox.getText()));
        editor.putString("country", Country.getSelectedItem().toString());
        editor.putString("city", City.getSelectedItem().toString());
        editor.putString("area", Area.getSelectedItem().toString());
        editor.apply();
        Intent iHel = new Intent(getApplicationContext(), GuardianInfoActivity.class);
        startActivity(iHel);
    } public void onButtonClick7(View v) {

        Intent iHel = new Intent(getApplicationContext(), StudentInfoActivity.class);
        startActivity(iHel);
    }
}
