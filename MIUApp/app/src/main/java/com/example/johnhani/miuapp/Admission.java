package com.example.johnhani.miuapp;

public class Admission {
    public int id;
    public String first_choice;
    public String second_choice;
    public String third_choice;
    public int st_id;
    public Admission(){};
    public Admission(int st_id,String first_choice,String second_choice,String third_choice){
        this.st_id=st_id;
        this.first_choice=first_choice;
        this.second_choice=second_choice;
        this.third_choice=third_choice;
    }
}
