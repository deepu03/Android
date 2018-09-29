package com.deepu.autocompletetextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    MultiAutoCompleteTextView mactv;
    AutoCompleteTextView actv;

    String language[]={"C++","Java","Python","C#",".Net","Android","Oracle"};
    String country[]={"India","Australia","China","USA","Russia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mactv=findViewById(R.id.mactv);
        actv=findViewById(R.id.actv);

        ArrayAdapter<String> adapter=new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,country);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,language);

        actv.setAdapter(adapter);
        actv.setThreshold(1);
        actv.setTextColor(Color.BLUE);
//Example: adding for multiple recpient in email
        mactv.setAdapter(arrayAdapter);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mactv.setThreshold(1);
        mactv.setTextColor(Color.BLACK);
    }

}
