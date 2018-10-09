package com.deepu.dbcrudlistviewdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql)
    {
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name,String email,String password ){

        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO RECORD VALUES(NULL,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);

        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,password);

        statement.executeInsert();
    }

    public void updateData(String name,String email,String password,int id)
    {
        SQLiteDatabase database=getWritableDatabase();
        String sql="UPDATE RECORD SET username=?, email=?, password=? WHERE id=?";
        SQLiteStatement statement=database.compileStatement(sql);

        statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,password);
        statement.bindDouble(4,id);

        statement.execute();
        database.close();

    }

    public void deleteData(int id){
        SQLiteDatabase database=getWritableDatabase();
        String sql="DELETE FROM RECORD WHERE id=?";

        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,id);
        statement.execute();
        database.close();
    }


    public Cursor getData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        return database.rawQuery(sql,null);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
