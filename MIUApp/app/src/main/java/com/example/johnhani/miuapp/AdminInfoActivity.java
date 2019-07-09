package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminInfoActivity extends AppCompatActivity {
    private Spinner FirstChoice;
    private Spinner SecondChoice;
    private Spinner ThirdChoice;
    private CheckBox inform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminstration_information);
        FirstChoice= (Spinner) findViewById(R.id.spiner1);
        SecondChoice= (Spinner) findViewById(R.id.spiner2);
        ThirdChoice= (Spinner) findViewById(R.id.spiner3);
        inform=(CheckBox) findViewById(R.id.checkbox);
    }

    public void onButtonClick5(View v) {
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("firstchoice", FirstChoice.getSelectedItem().toString());
        editor.putString("secondchoice", SecondChoice.getSelectedItem().toString());
        editor.putString("thirdchoice", ThirdChoice.getSelectedItem().toString());
            if(FirstChoice.getSelectedItem().toString()!=SecondChoice.getSelectedItem().toString()){
                if(FirstChoice.getSelectedItem().toString()!=ThirdChoice.getSelectedItem().toString()){
                    if(SecondChoice.getSelectedItem().toString()!=ThirdChoice.getSelectedItem().toString()){
                        editor.apply();
                        Intent iHel = new Intent(getApplicationContext(), OtherInfoActivity.class);
                        startActivity(iHel);
                    }
                }
            }
    }
    public void onButtonClick9(View v) {

        Intent iHel = new Intent(getApplicationContext(), MedicalInfoActivity.class);
        startActivity(iHel);
    }
}
