package com.deepu.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String array[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter(MainActivity.this,R.layout.list_layout,array);
        lv=findViewById(R.id.listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==5)
                {
                    Toast.makeText(MainActivity.this," MR Session",Toast.LENGTH_SHORT).show();
                }
                else if(position==0 || position==4)
                {
                    Toast.makeText(MainActivity.this,"Holiday",Toast.LENGTH_SHORT).show();
                }
                else if(position==1 || position==3 || position==5)
                {
                    Toast.makeText(MainActivity.this,"Lecture Session",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Unguided Practise",Toast.LENGTH_SHORT).show();
                }
            }
            });
        }
}
