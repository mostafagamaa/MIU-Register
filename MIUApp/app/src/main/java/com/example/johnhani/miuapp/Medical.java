package com.example.johnhani.miuapp;

public class Medical {
    public int id;
    public String chronic_disease;
    public String previous_disease;
    public String operations;
    public String medicine;
    public int st_id;
    public Medical(){};
    public Medical(String chronic_disease,String previous_disease,String operations,String medicine,int st_id){
        this.chronic_disease=chronic_disease;
        this.previous_disease=previous_disease;
        this.operations=operations;
        this.medicine=medicine;
        this.st_id=st_id;
    }
}