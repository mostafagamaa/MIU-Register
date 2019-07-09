package com.example.johnhani.miuapp;

public class BusLineRegistration {
    public int id;
    public String bus_line;
    public int st_id;
    public BusLineRegistration(){};
    public BusLineRegistration(String bus_line,int st_id){
        this.bus_line=bus_line;
        this.st_id=st_id;
    }
}
