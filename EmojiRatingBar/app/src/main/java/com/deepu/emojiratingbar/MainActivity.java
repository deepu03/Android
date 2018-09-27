package com.deepu.emojiratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    RatingBar rb;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
        rb=findViewById(R.id.ratingbar);
        rb.setStepSize(1);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b)
            {
                if(v==1.0){
                    Toast.makeText(MainActivity.this, "Poor ", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.emoji1);
                }
                if(v==2.0){
                    Toast.makeText(MainActivity.this, "Fair ", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.emoji2);
                }
                if(v==3.0){
                    Toast.makeText(MainActivity.this, "Good ", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.emoji3);
                }
                if(v==4.0){
                    Toast.makeText(MainActivity.this, "Very Good ", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.emoji4);
                }
                if(v==5.0){
                    Toast.makeText(MainActivity.this, "Excellent ", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.emoji5);
                }

            }
        });
    }
}
