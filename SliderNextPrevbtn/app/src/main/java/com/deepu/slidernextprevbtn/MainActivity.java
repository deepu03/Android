package com.deepu.slidernextprevbtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper=findViewById(R.id.viewflipper);
        prev=findViewById(R.id.previos);
        next=findViewById(R.id.next);

        next.setOnClickListener(this);
        prev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==next){
            viewFlipper.showNext();

        }
        else if(v==prev){
            viewFlipper.showPrevious();
        }

    }
}
