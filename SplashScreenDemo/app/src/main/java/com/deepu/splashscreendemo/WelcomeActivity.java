package com.deepu.splashscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView=findViewById(R.id.imageView);
        Animation animation1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation animation2=AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        final Animation animation3=AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide);
        final Animation animation4=AnimationUtils.loadAnimation(getBaseContext(),R.anim.myanim);
        final Animation animation5=AnimationUtils.loadAnimation(getBaseContext(),R.anim.blink);
        final Animation animation6=AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom);


        imageView.setAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setAnimation(animation2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setAnimation(animation3);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setAnimation(animation4);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setAnimation(animation5);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation5.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setAnimation(animation6);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation6.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
