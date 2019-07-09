package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class GuardianInfoActivity extends AppCompatActivity {
    private EditText guardianname;
    private EditText company;
    private EditText Guardianbusaddress;
    private EditText guardianphone;
    private EditText guardianemail;
    private EditText guardianmobile;
    private EditText guardianfax;
    private EditText mothername;
    private Spinner Profession;
    private CheckBox Hasbrotherorsister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guardian_information);
        guardianname=findViewById(R.id.fname);
        Profession= (Spinner) findViewById(R.id.spiner);
        company=findViewById(R.id.comp);
        Guardianbusaddress=findViewById(R.id.add);
        guardianphone=findViewById(R.id.phone);
        guardianemail=findViewById(R.id.email);
        guardianmobile=findViewById(R.id.studmo);
        guardianfax=findViewById(R.id.fax);
        mothername=findViewById(R.id.mothername);
        Hasbrotherorsister=findViewById(R.id.checkbox);


    }
    public void onButtonClick1(View v) {
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("gname", String.valueOf(guardianname.getText()));
        editor.putString("company", String.valueOf(company.getText()));
        editor.putString("guardianbusaddress", String.valueOf(Guardianbusaddress.getText()));
        editor.putString("guardianphoneno", String.valueOf(guardianphone.getText()));
        editor.putString("guardianemail", String.valueOf(guardianemail.getText()));
        editor.putString("guardianmobileno", String.valueOf(guardianmobile.getText()));
        editor.putString("guardianfax", String.valueOf(guardianfax.getText()));
        editor.putString("mothername", String.valueOf(mothername.getText()));
        editor.putString("profession", Profession.getSelectedItem().toString());
        editor.putInt("hasbrotherorsister", 0);
        editor.apply();
        Intent iHel = new Intent(getApplicationContext(), MedicalInfoActivity.class);
        startActivity(iHel);
    } public void onButtonClick8(View v) {

        Intent iHel = new Intent(getApplicationContext(), ContactInfoActivity.class);
        startActivity(iHel);
    }
}
