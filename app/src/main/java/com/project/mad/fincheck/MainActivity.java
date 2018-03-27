package com.project.mad.fincheck;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WaveLoadingView waveLoadingView=findViewById(R.id.lv);
        for(int i=0;i<100;i++){
            waveLoadingView.setProgressValue(i);
            if(i<50){
                waveLoadingView.setBottomTitle(String.format("%d%%",i));
                waveLoadingView.setCenterTitle("");
                waveLoadingView.setTopTitle("");
            }
            else if(i<80){
                waveLoadingView.setBottomTitle("");
                waveLoadingView.setCenterTitle(String.format("%d%%",i));
                waveLoadingView.setTopTitle("");
            }
            else{
                waveLoadingView.setBottomTitle("");
                waveLoadingView.setCenterTitle("");
                waveLoadingView.setTopTitle(String.format("%d%%",i));
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }
}
