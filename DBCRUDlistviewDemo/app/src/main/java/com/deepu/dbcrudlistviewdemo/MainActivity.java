package com.deepu.dbcrudlistviewdemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button add,list;
    public static SQLiteHelper mSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("New Record");

        e1=findViewById(R.id.username);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.password);
        add=findViewById(R.id.add);
        list=findViewById(R.id.list);

        mSQLiteHelper=new SQLiteHelper(this,"RECORDB",null,1);

        mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS RECORD(id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, email VARCHAR, password VARCHAR)");



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    mSQLiteHelper.insertData(e1.getText().toString().trim(),
                            e2.getText().toString().trim(),
                            e3.getText().toString().trim()

                    );
                    Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,RecordListActivity.class));
            }
        });
    }

}
