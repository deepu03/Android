package com.deepu.generaterandomcolorbackground;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        relativeLayout=findViewById(R.id.relativeLayout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                relativeLayout.setBackgroundColor(color);
            }
        });
    }
}
