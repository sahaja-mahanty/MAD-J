package com.project.mad.fincheck;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        WaveLoadingView waveLoadingView=findViewById(R.id.lv);
        for(int i=0;i<3000;i++){
            waveLoadingView.setProgressValue(i/30);
            if(i<50){
                waveLoadingView.setBottomTitle("");
                waveLoadingView.setCenterTitle("YOUR FINANCIAL HELPER");
                waveLoadingView.setTopTitle(String.format("%d%%",i/30));
            }
            else if(i<80){
                waveLoadingView.setBottomTitle("");
                waveLoadingView.setCenterTitle("YOUR FINANCIAL HELPER");
                waveLoadingView.setTopTitle(String.format("%d%%",i/30));
            }
            else{
                waveLoadingView.setBottomTitle("");
                waveLoadingView.setCenterTitle("YOUR FINANCIAL HELPER");
                waveLoadingView.setTopTitle(String.format("%d%%",i/30));
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
