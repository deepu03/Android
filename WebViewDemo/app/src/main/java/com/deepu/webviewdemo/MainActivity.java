package com.deepu.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webview);

        //webView.loadUrl("https://www.google.com/");

        //can be .html or .jsp local resources
        //webView.loadUrl("file:///android_asset/mybanner1.jpg");

        String data="<html><body><h1>Hello Android</h1></body></html>";
        webView.loadData(data, "text/html", "UTF-8");
    }
}
