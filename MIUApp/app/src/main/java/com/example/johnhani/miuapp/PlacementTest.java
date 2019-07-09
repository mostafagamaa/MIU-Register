package com.example.johnhani.miuapp;

public class PlacementTest {
    public int id;
    public String english_test_date;
    public String english_test_time;
    public String aptitude_test_date;
    public String aptitude_test_time;
    public int st_id;
    public PlacementTest(){};
    public PlacementTest(String en_date, String en_time, String ap_date, String ap_time, int st_id){
        this.english_test_date=en_date;
        this.english_test_time=en_time;
        this.aptitude_test_date=ap_date;
        this.aptitude_test_time=ap_time;
        this.st_id=st_id;
    }
}
