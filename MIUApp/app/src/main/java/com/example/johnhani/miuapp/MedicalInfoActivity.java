package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class MedicalInfoActivity extends AppCompatActivity {
    private Spinner Preillness;
    private Spinner usageofvision;
    private Spinner diseases;
    private Spinner Surgery;
    private Spinner Medcine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_information);
        Preillness= (Spinner) findViewById(R.id.spiner);
        usageofvision= (Spinner) findViewById(R.id.spiner1);
        diseases= (Spinner) findViewById(R.id.spiner2);
        Surgery= (Spinner) findViewById(R.id.spiner3);
        Medcine= (Spinner) findViewById(R.id.spiner4);

    }
    public void onButtonClick4(View v) {
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("preillness", Preillness.getSelectedItem().toString());
        editor.putString("usageofvision", usageofvision.getSelectedItem().toString());
        editor.putString("diseases", diseases.getSelectedItem().toString());
        editor.putString("surgery", Surgery.getSelectedItem().toString());
        editor.putString("medicine", Medcine.getSelectedItem().toString());
        editor.apply();
        Intent iHel = new Intent(getApplicationContext(), AdminInfoActivity.class);
        startActivity(iHel);
    } public void onButtonClick12(View v) {

        Intent iHel = new Intent(getApplicationContext(), GuardianInfoActivity.class);
        startActivity(iHel);
    }
}
