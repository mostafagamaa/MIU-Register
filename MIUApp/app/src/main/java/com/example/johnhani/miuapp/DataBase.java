package com.example.johnhani.miuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MIUApp";
    private static final int DATABASE_VERSION =1;
    public DataBase(Context c){super(c,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table5="CREATE TABLE ContactInfo (  id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, arabic_address TEXT, building_number TEXT, address TEXT, po_box TEXT)";
        db.execSQL(table5);
        String table1="CREATE TABLE User (  id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, nationality TEXT NOT NULL, gender TEXT NOT NULL, nationalID TEXT NOT NULL )";
        db.execSQL(table1);
        String table2="CREATE TABLE Student (  id INTEGER PRIMARY KEY AUTOINCREMENT, us_id INTEGER , date_of_birth TEXT , religion TEXT , contact_id INTEGER , place_of_birth TEXT , arabic_name TEXT , apply_date TEXT , FOREIGN KEY(us_id) REFERENCES User(id), FOREIGN KEY(contact_id) REFERENCES ContactInfo(id))";
        db.execSQL(table2);
        String table3="CREATE TABLE Guardian (  id INTEGER PRIMARY KEY AUTOINCREMENT, us_id INTEGER, profession TEXT, business_address TEXT, email TEXT, gname TEXT, company TEXT, mother_name TEXT, FOREIGN KEY(us_id) REFERENCES User(id))";
        db.execSQL(table3);
        String table4="CREATE TABLE Admin (  id INTEGER PRIMARY KEY AUTOINCREMENT, us_id INTEGER, hire_date TEXT, salary INTEGER, privilege INTEGER, FOREIGN KEY(us_id) REFERENCES User(id))";
        db.execSQL(table4);
        String table6="CREATE TABLE Medical (  id INTEGER PRIMARY KEY AUTOINCREMENT, chronic_disease TEXT, previous_disease TEXT, operations TEXT, medicine TEXT, st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id))";
        db.execSQL(table6);
        String table7="CREATE TABLE Admission (  id INTEGER PRIMARY KEY AUTOINCREMENT, first_choice TEXT, second_choice TEXT, third_choice TEXT, st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id) )";
        db.execSQL(table7);
        String table12="CREATE TABLE Phone (  id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, value TEXT, us_id INTEGER, FOREIGN KEY(us_id) REFERENCES User(id))";
        db.execSQL(table12);
        String table13="CREATE TABLE Certificate (  id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, country TEXT, school_city TEXT, school_name TEXT, year_of_graduation INTEGER, certificate TEXT, st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id))";
        db.execSQL(table13);
        String table14="CREATE TABLE PlacementTest (  id INTEGER PRIMARY KEY AUTOINCREMENT, english_test_date TEXT, english_test_time TEXT, aptitude_test_date TEXT, aptitude_test_time TEXT,st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id))";
        db.execSQL(table14);
        String table15="CREATE TABLE BusLineRegistration (  id INTEGER PRIMARY KEY AUTOINCREMENT, bus_line TEXT, st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id))";
        db.execSQL(table15);
        String table16="CREATE TABLE EmergencyContact (  id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, relation TEXT, address TEXT, phone_no TEXT, mobile_no TEXT, email TEXT,st_id INTEGER, FOREIGN KEY(st_id) REFERENCES Student(id))";
        db.execSQL(table16);
        String table17="CREATE TABLE Login (  id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE, password TEXT, role INTEGER, us_id INTEGER, FOREIGN KEY(us_id) REFERENCES User(id))";
        db.execSQL(table17);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertItem(User us){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",us.name);
        cv.put("nationality",us.nationality);
        cv.put("gender",us.gender);
        cv.put("nationalID",us.nationalID);
        db.insert("User",null,cv);
        db.close();
    }
    public void insertItem(Student st){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("us_id",st.us_id);
        cv.put("date_of_birth",st.date_of_birth);
        cv.put("religion",st.religion);
        cv.put("contact_id",st.contact_id);
        cv.put("place_of_birth",st.place_of_birth);
        cv.put("arabic_name",st.arabic_name);
        cv.put("apply_date",st.apply_date);
        db.insert("Student",null,cv);
        db.close();
    }
    public void insertItem(Admin ad){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("us_id",ad.us_id);
        cv.put("hire_date",ad.hire_date);
        cv.put("salary",ad.salary);
        cv.put("privilege",ad.privilege);
        db.insert("Admin",null,cv);
        db.close();
    }
    public void insertItem(Guardian gu){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("us_id",gu.us_id);
        cv.put("profession",gu.profession);
        cv.put("business_address",gu.business_address);
        cv.put("email",gu.email);
        cv.put("gname",gu.gname);
        cv.put("company",gu.company);
        cv.put("mother_name",gu.mother_name);
        db.insert("Guardian",null,cv);
        db.close();
    }
    public void insertItem(Admission adm){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("first_choice",adm.first_choice);
        cv.put("second_choice",adm.second_choice);
        cv.put("third_choice",adm.third_choice);
        cv.put("st_id",adm.st_id);
        db.insert("Admission",null,cv);
        db.close();
    }
    public void insertItem(ContactInfo co){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",co.email);
        cv.put("arabic_address",co.arabic_address);
        cv.put("building_number",co.building_number);
        cv.put("address",co.address);
        cv.put("po_box",co.po_box);
        db.insert("ContactInfo",null,cv);
        db.close();
    }
    public void insertItem(BusLineRegistration bu){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("bus_line",bu.bus_line);
        cv.put("st_id",bu.st_id);
        db.insert("BusLineRegistration",null,cv);
        db.close();
    }
    public void insertItem(Certificate ce){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("type",ce.type);
        cv.put("country",ce.country);
        cv.put("school_city",ce.school_city);
        cv.put("school_name",ce.school_name);
        cv.put("year_of_graduation",ce.year_of_graduation);
        cv.put("certificate",ce.certificate);
        cv.put("st_id",ce.st_id);
        db.insert("Certificate",null,cv);
        db.close();
    }
    public void insertItem(PlacementTest pl){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("english_test_date",pl.english_test_date);
        cv.put("english_test_time",pl.english_test_time);
        cv.put("aptitude_test_date",pl.aptitude_test_date);
        cv.put("aptitude_test_time",pl.aptitude_test_time);
        cv.put("st_id",pl.st_id);
        db.insert("PlacementTest",null,cv);
        db.close();
    }
    public void insertItem(EmergencyContact em){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",em.name);
        cv.put("relation",em.relation);
        cv.put("address",em.address);
        cv.put("phone_no",em.phone_no);
        cv.put("mobile_no",em.mobile_no);
        cv.put("name",em.email);
        cv.put("st_id",em.st_id);
        db.insert("EmergencyContact",null,cv);
        db.close();
    }
    public void insertItem(Medical me){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("chronic_disease",me.chronic_disease);
        cv.put("previous_disease",me.previous_disease);
        cv.put("operations",me.operations);
        cv.put("medicine",me.medicine);
        cv.put("st_id",me.st_id);
        db.insert("Medical",null,cv);
        db.close();
    }
    public void insertItem(Address add){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("value",add.value);
        cv.put("level",add.level);
        cv.put("parent_id",add.parent_id);
        db.insert("Address",null,cv);
        db.close();
    }

    public void insertItem(Phone ph){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("type",ph.type);
        cv.put("value",ph.value);
        cv.put("us_id",ph.us_id);
        db.insert("Phone",null,cv);
        db.close();
    }
    public void insertItem(Login lo){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",lo.username);
        cv.put("password",lo.password);
        cv.put("role",lo.role);
        cv.put("us_id",lo.us_id);
        db.insert("Login",null,cv);
        db.close();
    }
    public int[] login(String username,String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Login where username ='"+username+"' AND password ='"+password+"'";
        Cursor result = db.rawQuery(query, null);
        int res[]=new int[3];
        if (result.moveToFirst()) {
            int us_id = result.getInt(4);
            int role = result.getInt(3);
            res[1]=1;
            res[2]=role;
            res[0]=us_id;
            db.close();
            return  res;
        }
        else{
            res[0]=0;
            db.close();
            return  res;
        }
    }
    public ArrayList<String[]> getStudents(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Student";
        Cursor result = db.rawQuery(query, null);
        ArrayList<String[]> res = new ArrayList<>();
        if (result.moveToFirst()) {
            do {
                int st_id = result.getInt(0);
                int us_id = result.getInt(1);
                String query1 = "SELECT * FROM User WHERE id ="+us_id;

                Cursor result1 = db.rawQuery(query1, null);
                if (result1.moveToFirst()) {
                    int id = result.getInt(0);
                    String name = result1.getString(1);
                    String array[]=new String[2];
                    array[0]=name;
                    array[1]=result.getString(7);
                    res.add(array);
                }

            } while (result.moveToNext());
        }
        db.close();
        return res;

    }
    public String[] get_exam_date_time(int st_id){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM PlacementTest WHERE st_id ="+st_id;
        Cursor result = db.rawQuery(query, null);
        String res[]=new String[4];
        if(result.moveToFirst()){
            String eng_date = result.getString(1);
            String eng_time = result.getString(2);
            String ap_date = result.getString(3);
            String ap_time = result.getString(4);
            res[0]=eng_date;
            res[1]=eng_time;
            res[2]=ap_date;
            res[3]=ap_time;
        }
        db.close();
        return  res;
    }
    public int get_us_id(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM    User WHERE   id = (SELECT MAX(id)  FROM User);";
        Cursor result = db.rawQuery(query, null);
       int us_id;
        if (result.moveToFirst()) {
                us_id = result.getInt(0);
                db.close();
                return us_id;
        }
     return -1;
    }
    public int get_st_id(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM    Student  WHERE   id = (SELECT MAX(id)  FROM Student);";
        Cursor result = db.rawQuery(query, null);
        int st_id;
        if (result.moveToFirst()) {
            st_id = result.getInt(0);
            db.close();
            return st_id;
        }
        return -1;
    }
    public int get_contactinfo_id(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM  ContactInfo  WHERE   id = (SELECT MAX(id)  FROM ContactInfo);";
        Cursor result = db.rawQuery(query, null);
        int contactinfo_id;
        if (result.moveToFirst()) {
            contactinfo_id = result.getInt(0);
            db.close();
            return contactinfo_id;
        }
        return -1;
    }
    public int get_Student(int us_id){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Student WHERE us_id ="+us_id;
        Cursor result = db.rawQuery(query, null);
        if (result.moveToFirst()) {
            int res= result.getInt(0);
            db.close();
            return res;
        }
       return -1;


    }


}
