package com.example.johnhani.miuapp;

public class Certificate {
    public int id;
    public String type;
    public String country;
    public String school_city;
    public String school_name;
    public String year_of_graduation;
    public String certificate;
    public int st_id;
    public Certificate(){};
    public Certificate(String type,String country,String school_city,String school_name,String year_of_graduation,String certificate, int st_id){
        this.type=type;
        this.country=country;
        this.school_name=school_name;
        this.year_of_graduation=year_of_graduation;
        this.certificate=certificate;
        this.st_id=st_id;
        this.school_city=school_city;
    }
}
