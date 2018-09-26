package com.deepu.checkboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
    }
    
    public void onOrderButtonClick(View view)
    {
        int amount=0;
        StringBuilder builder=new StringBuilder();

        if(c1.isChecked() || c2.isChecked() || c3.isChecked()) {
            builder.append("Selected Items: ");
            if (c1.isChecked()) {
                builder.append("\n Pizza :Rs.120");
                amount += 120;
            }
            if (c2.isChecked()) {
                builder.append("\n Burger :Rs.100");
                amount += 100;
            }
            if (c3.isChecked()) {
                builder.append("\n Coffee :Rs.50");
                amount += 50;
            }
            builder.append("\n Total Amount Rs.: " + amount);
            Toast.makeText(getApplicationContext(), builder.toString(), Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Please select items from the menu", Toast.LENGTH_LONG).show();
        }


    }
}
