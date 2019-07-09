package com.example.johnhani.miuapp;

public class Admin {
    public int id;
    public int us_id;
    public String hire_date;
    public int salary;
    public int privilege;
    public Admin(){};
    public Admin(int us_id,String hire_date,int salary,int privilege){
        this.us_id=us_id;
        this.salary=salary;
        this.privilege=privilege;
        this.hire_date=hire_date;
    }
}
