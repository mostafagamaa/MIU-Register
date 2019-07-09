package com.example.johnhani.miuapp;

public class Address {
    public int id;
    public String value;
    public int level;
    public int parent_id;
    public Address(){};
    public Address(String value,int level,int parent_id){
        this.value=value;
        this.level=level;
        this.parent_id=parent_id;
    }
}
