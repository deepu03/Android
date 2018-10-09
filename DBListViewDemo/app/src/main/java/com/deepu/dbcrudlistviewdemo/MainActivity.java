package com.deepu.dbcrudlistviewdemo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button register,view;
    SQLiteDatabase SQLITEDATABASE;
    String username,email,password;
    Boolean CheckEditTextEmpty;
    String SQLiteQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.username);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.password);
        register=findViewById(R.id.register);
        view=findViewById(R.id.view);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBcreate();
                SubmitDataSQLiteDB();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void DBcreate()
    {
        SQLITEDATABASE=openOrCreateDatabase("mydb", Context.MODE_PRIVATE,null);
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS userdata(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,username VARCHAR,email VARCHAR,password VARCHAR);");
    }

    public void SubmitDataSQLiteDB()
    {
        username=e1.getText().toString();
        email=e2.getText().toString();
        password=e3.getText().toString();

        CheckEditTextEmptyorNot(username,email,password);

        if(CheckEditTextEmpty==true){
            SQLiteQuery="INSERT INTO userdata(username,email,password) VALUES('"+username+"','"+email+"','"+password+"');";
            
            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(this, "Data Sumbitted Successfully", Toast.LENGTH_SHORT).show();

            ClearEditTextAfterDoneTask();
            
        }
        else{
            Toast.makeText(this, "Please fill all the Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void CheckEditTextEmptyorNot(String username,String email,String password){
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            CheckEditTextEmpty=false;
        }
        else {
            CheckEditTextEmpty=true;
        }
   }

   public void ClearEditTextAfterDoneTask()
   {
       e1.getText().clear();
       e2.getText().clear();
       e3.getText().clear();
   }
}
