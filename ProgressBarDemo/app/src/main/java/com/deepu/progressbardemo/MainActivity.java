package com.deepu.progressbardemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button button;
    ProgressBar progressBar;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgress();

            }
        });


    }
    public void setProgress(){
        if(count<=100) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(count);
                    count++;
                    setProgress();
                }
            }, 100);
        }
        else
        {
            count=1;
            Toast.makeText(this, "Movie downloaded successfully!!!", Toast.LENGTH_SHORT).show();
   }
   }
    }
