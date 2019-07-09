package com.example.johnhani.miuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class OtherInfoActivity extends AppCompatActivity {
    private Spinner CertificateType;
    private Spinner Certificate;
    private Spinner SchoolCountry;
    private Spinner SchoolCity;
    private Spinner SchoolName;
    private Spinner YearOfGraduation;
    private Spinner EnglishExamDay;
    private Spinner EnglishExamTime;
    private Spinner AptitudeExamDay;
    private Spinner AptitudeExamTime;
    private TextView username;
    private TextView password;
    private DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificate_information);
        CertificateType= (Spinner) findViewById(R.id.spiner);
        Certificate= (Spinner) findViewById(R.id.spiner2);
        SchoolCountry= (Spinner) findViewById(R.id.spiner3);
        SchoolCity= (Spinner) findViewById(R.id.spiner4);
        SchoolName= (Spinner) findViewById(R.id.spiner5);
        YearOfGraduation= (Spinner) findViewById(R.id.spiner6);
        EnglishExamDay= (Spinner) findViewById(R.id.spiner7);
        EnglishExamTime= (Spinner) findViewById(R.id.spiner8);
        AptitudeExamDay= (Spinner) findViewById(R.id.spiner9);
        AptitudeExamTime= (Spinner) findViewById(R.id.spiner10);
        username= (TextView) findViewById(R.id.editText11);
        password= (TextView) findViewById(R.id.editText12);

    }
    public void onButtonClick6(View v) {
        //we save all info to database that is in shared pref.
        //put info in shared pref.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("CertificateType", CertificateType.getSelectedItem().toString());
        editor.putString("Certificate", Certificate.getSelectedItem().toString());
        editor.putString("SchoolCountry", SchoolCountry.getSelectedItem().toString());
        editor.putString("SchoolCity", SchoolCity.getSelectedItem().toString());
        editor.putString("SchoolName", SchoolName.getSelectedItem().toString());
        editor.putString("YearOfGraduation", YearOfGraduation.getSelectedItem().toString());
        editor.putString("EnglishExamDay", EnglishExamDay.getSelectedItem().toString());
        editor.putString("EnglishExamTime", EnglishExamTime.getSelectedItem().toString());
        editor.putString("AptitudeExamDay", AptitudeExamDay.getSelectedItem().toString());
        editor.putString("AptitudeExamTime", AptitudeExamTime.getSelectedItem().toString());
        editor.putString("username", String.valueOf(username.getText()));
        editor.putString("password", String.valueOf(password.getText()));
        editor.apply();
        savetodatabase();
        Intent iHel = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(iHel);
    }
    public void onButtonClick10(View v) {

        Intent iHel = new Intent(getApplicationContext(), AdminInfoActivity.class);
        startActivity(iHel);
    }
    public void savetodatabase(){
        db =new DataBase(this);
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String name=prefs.getString("fname", "empty")+" "+prefs.getString("mname", "empty")+" "+prefs.getString("lname", "empty");
        User us=new User(name,prefs.getString("nationality", "empty"),prefs.getString("gender", "empty"),prefs.getString("nationalid", "empty"));
        db.insertItem(us);
        int us_id=db.get_us_id();
        ///////////////////////////////////////////////////////////////////////////////////
        String address=prefs.getString("area", "empty")+" "+prefs.getString("city", "empty")+" "+prefs.getString("country", "empty");
        ContactInfo co =new ContactInfo(prefs.getString("email", "empty"),prefs.getString("arabicaddress", "empty"),prefs.getString("buildingno", "empty"),address,prefs.getString("pobox", "empty"));
        db.insertItem(co);
        int contactinfo_id=db.get_contactinfo_id();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        Date currentTime = Calendar.getInstance().getTime();
        String arabicname=prefs.getString("fnamearabic", "empty")+" "+prefs.getString("mnamearabic", "empty")+" "+prefs.getString("lnamearabic", "empty");
        Student st =new Student(us_id,prefs.getString("dob", "empty"),prefs.getString("religion", "empty"),contactinfo_id,prefs.getString("pob", "empty"),arabicname,currentTime.toString());
        db.insertItem(st);
        int st_id=db.get_st_id();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        Medical me=new Medical(prefs.getString("preillness", "empty"),prefs.getString("diseases", "empty"),prefs.getString("surgery", "empty"),prefs.getString("medicine", "empty"),st_id);
        db.insertItem(me);
        /////////////////////////////////////////////
        Admission ad=new Admission(st_id,prefs.getString("firstchoice", "empty"),prefs.getString("secondchoice", "empty"),prefs.getString("thirdchoice", "empty"));
        db.insertItem(ad);
        /////////////////////////////////////////////
        Guardian gu=new Guardian(us_id,prefs.getString("profession", "empty"),prefs.getString("guardianbusaddress", "empty"),prefs.getString("guardianemail", "empty"),prefs.getString("gname", "empty"),prefs.getString("company", "empty"),prefs.getString("mothername", "empty"));
        db.insertItem(gu);
        /////////////////////////////////////////////////
        PlacementTest pl=new PlacementTest(prefs.getString("EnglishExamDay", "empty"),prefs.getString("EnglishExamTime", "empty"),prefs.getString("AptitudeExamDay", "empty"),prefs.getString("AptitudeExamTime", "empty"),st_id);
        db.insertItem(pl);
        ///////////////////////////////////////////////
        Certificate ce=new Certificate(prefs.getString("CertificateType", "empty"),prefs.getString("Certificate", "empty"),prefs.getString("SchoolCountry", "empty"),prefs.getString("SchoolCity", "empty"),prefs.getString("SchoolName", "empty"),prefs.getString("YearOfGraduation", "empty"),st_id);
        db.insertItem(ce);
        /////////////////////////////////////////
        Login lo=new Login(prefs.getString("username", "empty"),prefs.getString("password", "empty"),0,us_id);
        db.insertItem(lo);
        /////////////////////////////////////////
        Phone studentmobileno=new Phone("studentmobileno",prefs.getString("studentmobileno", "empty"),us_id);
        db.insertItem(studentmobileno);
        /////////////////////////////////////////
        Phone studentphoneno=new Phone("studentphoneno",prefs.getString("studentphoneno", "empty"),us_id);
        db.insertItem(studentphoneno);
        /////////////////////////////////////////
        Phone guardianmobileno=new Phone("guardianmobileno",prefs.getString("guardianmobileno", "empty"),us_id);
        db.insertItem(guardianmobileno);
        /////////////////////////////////////////
        Phone guardianphoneno=new Phone("guardianphoneno",prefs.getString("guardianphoneno", "empty"),us_id);
        db.insertItem(guardianphoneno);
        /////////////////////////////////////////
        Phone guardianfax=new Phone("guardianfax",prefs.getString("guardianfax", "empty"),us_id);
        db.insertItem(guardianfax);
        /////////////////////////////////////////
    }
}
