package com.deepu.seekbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb=findViewById(R.id.sb);
        iv=findViewById(R.id.iv);

        sb.setMax(100);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>=0 && progress<=30)
                {
                    iv.setImageResource(R.drawable.emoji1);

                }
                else if(progress>=31 && progress<=80)
                {
                    iv.setImageResource(R.drawable.emoji2);
                }
                else{
                    iv.setImageResource(R.drawable.emoji3);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
