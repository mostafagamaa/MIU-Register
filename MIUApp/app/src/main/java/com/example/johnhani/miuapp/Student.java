package com.example.johnhani.miuapp;

public class Student {
    public int id;
    public int us_id;
    public String date_of_birth;
    public String religion;
    public int contact_id;
    public String place_of_birth;
    public String arabic_name;
    public String apply_date;
    public Student(){};
    public Student(int us_id,String date_of_birth,String religion,int contact_id,String place_of_birth,String arabic_name,String apply_date){
        this.us_id=us_id;
        this.date_of_birth=date_of_birth;
        this.religion=religion;
        this.contact_id=contact_id;
        this.place_of_birth=place_of_birth;
        this.arabic_name=arabic_name;
        this.apply_date=apply_date;
    }
}
