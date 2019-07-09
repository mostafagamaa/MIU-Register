package com.example.johnhani.miuapp;

public class Phone {
    public int id;
    public String type;
    public String value;
    public int us_id;
    public Phone(){};
    public Phone(String type,String value,int us_id){
        this.type=type;
        this.value=value;
        this.us_id=us_id;
    }
}
