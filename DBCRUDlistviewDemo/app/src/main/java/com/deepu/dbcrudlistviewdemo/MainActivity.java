package com.deepu.dbcrudlistviewdemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    Button add, list;
    public static SQLiteHelper mSQLiteHelper;
    boolean CheckEditTextEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("New Record");

        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.email);
        e3 = findViewById(R.id.password);
        add = findViewById(R.id.add);
        list = findViewById(R.id.list);

        mSQLiteHelper = new SQLiteHelper(this, "RECORDB", null, 1);

        mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS RECORD(id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, email VARCHAR, password VARCHAR)");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String username = e1.getText().toString().trim();
                    String email = e2.getText().toString().trim();
                    String pwd = e3.getText().toString().trim();

                    CheckEditTextEmptyorNot(username, email, pwd);

                    if (CheckEditTextEmpty == true) {
                        mSQLiteHelper.insertData(e1.getText().toString().trim(),
                                e2.getText().toString().trim(),
                                e3.getText().toString().trim()


                        );

                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Please fill All the Fields", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RecordListActivity.class));
            }
        });
    }

    public void CheckEditTextEmptyorNot(String username, String email, String pwd) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {

            CheckEditTextEmpty = false;
        } else {
            CheckEditTextEmpty = true;
        }
    }


}
