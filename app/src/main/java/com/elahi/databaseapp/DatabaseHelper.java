package com.elahi.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="elahi.db";
    private static final String TABLE_NAME="tblEmployee";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"( ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT, DEPARTMENT TEXT,MOBILE_NUMBER TEXT,EMAIL TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(int id,String name,String Dept,String CellNo,String email){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("ID",id);
        contentValues.put("NAME",name);
        contentValues.put("DEPARTMENT",Dept);
        contentValues.put("MOBILE_NUMBER",CellNo);
        contentValues.put("EMAIL",email);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1) return false;
        else return true;


    }
    public int UpdateData(String a,int id,int type){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        if(type==1){
            contentValues.put("DEPARTMENT",a);
        }
        else if(type==2){
            contentValues.put("MOBILE_NUMBER",a);
        }
        else if(type==3){contentValues.put("EMAIL",a);}
        int result= sqLiteDatabase.update(TABLE_NAME,contentValues,"ID="+id,null);
        return result;
    }
    public Cursor SearchData(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query= "SELECT *FROM tblEmployee WHERE ID=" + id;
        Cursor res =sqLiteDatabase.rawQuery(query,null);
        return res;
    }
    public int DeleteData(int id){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        return(sqLiteDatabase.delete(TABLE_NAME,"ID="+id,null));
    }
}
