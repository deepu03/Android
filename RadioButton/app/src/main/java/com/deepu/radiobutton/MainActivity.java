package com.deepu.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.rg);

    }

    public void onSubmitButtonClick(View view)
    {
        int id=rg.getCheckedRadioButtonId();
        rb=findViewById(id);
        Toast.makeText(this, "You have selected :"+rb.getText()+" course", Toast.LENGTH_SHORT).show();
    }
}
