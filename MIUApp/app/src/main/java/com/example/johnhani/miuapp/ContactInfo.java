package com.example.johnhani.miuapp;

public class ContactInfo {
    public int id;
    public String email;
    public String arabic_address;
    public String building_number;
    public String address;
    public String po_box;
    public ContactInfo(){};
    public ContactInfo(String email,String arabic_address,String building_number,String address,String po_box){
        this.email=email;
        this.arabic_address=arabic_address;
        this.building_number=building_number;
        this.address=address;
        this.po_box=po_box;
    }
}
