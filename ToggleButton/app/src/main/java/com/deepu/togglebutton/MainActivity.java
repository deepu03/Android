package com.deepu.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb1,tb2;
    Button btn;
//switch for sliding togglebutton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onSubmitButtonClick();
    }

    public void onSubmitButtonClick()
    {
        tb1=findViewById(R.id.tb1);
        tb2=findViewById(R.id.tb2);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder=new StringBuilder();
                builder.append("Toggle Button 1:  ").append(tb1.getText());
                builder.append("\n Toggle Button 2:  ").append(tb2.getText());

                Toast.makeText(getApplicationContext(), builder.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
