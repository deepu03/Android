package com.deepu.dbcrudlistviewdemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    SQLiteDatabase SQLITEDATABASE;
    SQLiteHelper SQLITEHELPER;
    Cursor cursor;
    SQLiteListAdapter ListAdapter;

    ArrayList<String> id_arr=new ArrayList<>();
    ArrayList<String> username_arr=new ArrayList<>();
    ArrayList<String> email_arr=new ArrayList<>();
    ArrayList<String> password_arr=new ArrayList<>();

    ListView LISTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        LISTVIEW=findViewById(R.id.listview);

        SQLITEHELPER =new SQLiteHelper(this);

    }

    @Override
    protected void onResume() {

        ViewSQLiteDBData();

        super.onResume();
    }


    private void ViewSQLiteDBData()
    {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor=SQLITEDATABASE.rawQuery("SELECT * from userdata",null);

        id_arr.clear();
        username_arr.clear();
        email_arr.clear();
        password_arr.clear();

        if(cursor.moveToFirst()){

            do {
                id_arr.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_id)));
                username_arr.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_username)));
                password_arr.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_password)));
                email_arr.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_email)));
            }while (cursor.moveToNext());
        }
        ListAdapter=new SQLiteListAdapter(ListViewActivity.this,id_arr,username_arr,email_arr,password_arr);
        LISTVIEW.setAdapter(ListAdapter);


        cursor.close();


    }


}
