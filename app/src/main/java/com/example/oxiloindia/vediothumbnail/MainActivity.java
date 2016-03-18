package com.example.oxiloindia.vediothumbnail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public int currentimageindex=0;
    ImageView slidingimage,slidingimage2,slidingimage3,back,forward;
    final Handler mHandler=new Handler();

    private int[] IMAGE_IDS = {
            R.drawable.a, R.drawable.aa, R.drawable.logo,
            R.drawable.start_scr, R.drawable.sample0, R.drawable.splash_scr_cc, R.drawable.sample5, R.drawable.sample1, R.drawable.sample6,
            R.drawable.sample7, R.drawable.valen
    };

    private int[] IMAGE_IDS1 = {
            R.drawable.logo,
            R.drawable.start_scr, R.drawable.sample0, R.drawable.splash_scr_cc, R.drawable.sample5, R.drawable.sample1, R.drawable.sample6,
            R.drawable.sample7, R.drawable.valen,R.drawable.a, R.drawable.aa,
    };

    private int[] IMAGE_IDS2 = {
            R.drawable.logo,
            R.drawable.start_scr, R.drawable.sample0, R.drawable.splash_scr_cc, R.drawable.sample5, R.drawable.sample1, R.drawable.sample6,
            R.drawable.sample7, R.drawable.valen,R.drawable.a, R.drawable.aa
    };

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Autorun();
    }

    public void Autorun(){
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
                AnimateandSlideShow();
            }
        };
        final Runnable mUpdateResults1 = new Runnable() {
            public void run() {
                AnimateandSlideShow1();
            }
        }; final Runnable mUpdateResults2 = new Runnable() {
            public void run() {
                AnimateandSlideShow2();
            }
        };
        int delay = 500; // delay for 1/2 sec.
        int period = 1000; // repeat every 1 sec.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mHandler.post(mUpdateResults);
                mHandler.post(mUpdateResults1);
                mHandler.post(mUpdateResults2);
            }
        }, delay, period);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Autorun();
    }

    private void AnimateandSlideShow() {
        slidingimage = (ImageView)findViewById(R.id.ImageView_Left);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
        currentimageindex++;}

    private void AnimateandSlideShow1() {
        slidingimage2 = (ImageView)findViewById(R.id.ImageView_center);
        slidingimage2.setImageResource(IMAGE_IDS1[currentimageindex%IMAGE_IDS.length]);
        currentimageindex++;
        Animation animation1=new TranslateAnimation(20.0f, 0.0f, 0.0f, 0.0f);
        animation1.setDuration(60);
        slidingimage2.startAnimation(animation1);}

    private void AnimateandSlideShow2() {
        slidingimage3 = (ImageView)findViewById(R.id.ImageView_right);
        slidingimage3.setImageResource(IMAGE_IDS2[currentimageindex%IMAGE_IDS.length]);
        currentimageindex++;
        Animation animation1=new TranslateAnimation(20.0f, 0.0f, 0.0f, 0.0f);
        animation1.setDuration(80);
        slidingimage3.startAnimation(animation1);}
}