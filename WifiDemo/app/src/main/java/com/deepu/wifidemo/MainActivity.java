package com.deepu.wifidemo;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button on,off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on=findViewById(R.id.on);
        off=findViewById(R.id.off);

        final WifiManager manager= (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setWifiEnabled(true);
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setWifiEnabled(false);
            }
        });
    }
}
