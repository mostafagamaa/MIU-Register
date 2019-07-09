package com.example.johnhani.miuapp;

public class User {
    public int id;
    public String name;
    public String nationality;
    public String gender;
    public String nationalID;
    public User(){};
    public User(String name,String nationality,String gender,String nationalID){
        this.name=name;
        this.nationality=nationality;
        this.gender=gender;
        this.nationalID=nationalID;
    }
}
