package com.deepu.fragmentdemo;

//you just have to import android.support.v4.app.Fragment; in the all the FragmentClass();. that's it.
import android.support.v4.app.Fragment;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ActionBar.Tab tab1,tab2;


    Fragment f1= new Login();
    Fragment f2= new Registration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1=actionBar.newTab().setText("Login");
        tab2=actionBar.newTab().setText("Register");


        tab1.setTabListener(new TabListener(f1));
        tab2.setTabListener(new TabListener(f2));

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
           }
}
