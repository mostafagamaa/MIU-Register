package com.example.johnhani.miuapp;

public class EmergencyContact {
    public int id;
    public String name;
    public String relation;
    public String address;
    public String phone_no;
    public String mobile_no;
    public String email;
    public int st_id;
    public EmergencyContact(){};
    public EmergencyContact(String name,String relation, String address,String phone_no,String mobile_no,String email,int st_id){
        this.name=name;
        this.relation=relation;
        this.address=address;
        this.phone_no=phone_no;
        this.mobile_no=mobile_no;
        this.email=email;
        this.st_id=st_id;
    }

}
