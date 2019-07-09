package com.example.johnhani.miuapp;

public class Login {
    public int id;
    public String username;
    public String password;
    public int role;
    public int us_id;
    public Login(){};
    public Login(String username,String password,int role,int us_id){
        this.username=username;
        this.password=password;
        this.role=role;
        this.us_id=us_id;
    }
}
