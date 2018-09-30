package com.deepu.datetimepickerdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2;
    Button btn1,btn2;
    private int day,year,month,hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.equals(btn1)){
            Calendar calendar=Calendar.getInstance();
            day=calendar.get(Calendar.DAY_OF_MONTH);
            year=calendar.get(Calendar.YEAR);
            month=calendar.get(Calendar.MONTH);

            DatePickerDialog datePickerDialog=new  DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    e1.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                }
            },year,month,day);
            datePickerDialog.show();


             }

             if (view.equals(btn2)){
                Calendar calendar=Calendar.getInstance();
                hour=calendar.get(Calendar.HOUR_OF_DAY);
                minute=calendar.get(Calendar.MINUTE);

                 TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         e2.setText(hourOfDay+":"+minute);
                     }
                 },hour,minute,false);
                    timePickerDialog.show();
             }

    }
}
