package com.example.johnhani.miuapp;

public class Guardian {
    public int id;
    public int us_id;
    public String profession;
    public String business_address;
    public String email;
    public String gname;
    public String company;
    public String mother_name;
    public Guardian(){};
    public Guardian(int us_id, String profession, String business_address, String email, String gname, String company, String mother_name){
        this.us_id=us_id;
        this.profession=profession;
        this.business_address=business_address;
        this.email=email;
        this.gname=gname;
        this.company=company;
        this.mother_name=mother_name;
    }
}
