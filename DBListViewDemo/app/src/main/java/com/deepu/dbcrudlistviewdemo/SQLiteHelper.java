package com.deepu.dbcrudlistviewdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME = "mydb";
    public static final String TABLE_NAME="userdata";
    public static final String KEY_id="id";
    public static final String KEY_username="username";
    public static final String KEY_email="email";
    public static final String KEY_password="password";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {
try {
    String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_id + " INTEGER PRIMARY KEY ," + KEY_username + " VARCHAR," + KEY_email + " VARCHAR," + KEY_password + " VARCHAR)";
    db.execSQL(CREATE_TABLE);
}catch (SQLiteException e){
    e.getMessage();
}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
