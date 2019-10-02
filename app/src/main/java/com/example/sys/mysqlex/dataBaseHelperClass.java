package com.example.sys.mysqlex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBaseHelperClass extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="students_record.db";
    public static final String TABLE_NAME="students_table";
    public static final String STUDENTS_NAME="students_name";
    public static final String STUDENTS_PASSWORD="students_password";
    public static final String STUDENTS_ROLLNUMBER="students_rollnumber";


    public dataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 2);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_NAME + " ( " + STUDENTS_NAME + " text , "+ STUDENTS_PASSWORD +
            " text ,"+ STUDENTS_ROLLNUMBER
            +" text primary key )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public  boolean insert_data(String name,String password, String roll_number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENTS_PASSWORD,password);
        contentValues.put(STUDENTS_ROLLNUMBER,roll_number);
        contentValues.put(STUDENTS_NAME,name);
        long res=db.insert(TABLE_NAME,null,contentValues);
        return res != -1;
    }
    public Cursor  showalldatas()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+ TABLE_NAME , null);
        return  res;

    }
    public Cursor showspecificdatas(String name)
    {
     SQLiteDatabase db =this.getReadableDatabase();
     String query="select * from "+TABLE_NAME + " where " + STUDENTS_ROLLNUMBER + " =? " ;
     Cursor res = db.rawQuery(query,new String[]{name});
     return  res;
    }
    public  Cursor findmealone(String rollno)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query ="select * from "+TABLE_NAME + " where " + STUDENTS_ROLLNUMBER + " =? ";
        Cursor res = db.rawQuery(query , new String[]{rollno});
        return res;
    }
    public  boolean edit_data(String name,String password, String newpass,String old)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENTS_PASSWORD,password);
        contentValues.put(STUDENTS_ROLLNUMBER,newpass);
        contentValues.put(STUDENTS_NAME,name);
        int res=db.update(TABLE_NAME,contentValues,STUDENTS_ROLLNUMBER + "=?",new String[]{old});
        if(res==1)
            return true;
        else
            return false;
    }
    public boolean del_data(String roll_no)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Integer res=db.delete(TABLE_NAME,STUDENTS_ROLLNUMBER + "=?",new String[]{roll_no});
        if(res==1)
            return true;
        else
            return false;

    }
}
