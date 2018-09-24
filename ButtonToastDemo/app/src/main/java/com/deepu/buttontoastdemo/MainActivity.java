package com.deepu.buttontoastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);

    }

    public void onClick(View view)
    {
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());
        int sum=num1 + num2;
        //using setMargin()  method of Toast class
        Toast toast=Toast.makeText(this,"YOUR RESULT",Toast.LENGTH_LONG);
        toast.setMargin(0,0);//at toast position only
         toast.show();

        Toast.makeText(this, "SUM: "+String.valueOf(sum), Toast.LENGTH_LONG).show();


    }
}
