package com.example.rara.beritaku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView persen;
    ProgressBar pb;
    Handler handler = new Handler();
    int progresStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        persen = (TextView)findViewById(R.id.persen);
        pb = (ProgressBar)findViewById(R.id.progbar);
        progresStatus = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progresStatus < 100){
                    progresStatus += 1;
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(progresStatus);
                            persen.setText(progresStatus + "%");
                            if (progresStatus == 100){
                                persen.setText("Complete");
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }

                        }
                    });
                }
            }
        }).start();
    }
}
