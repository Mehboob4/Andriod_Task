package com.elahi.databaseapp;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        final ProgressBar prg;
        prg=(ProgressBar)findViewById(R.id.progressBar);
        prg.setMax(100);
        prg.setProgress(0);
        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try
                {   int n=0;
                    for(int i=0 ; i<5 ; i++)
                    {
                        prg.setProgress(n);
                        sleep(1000);
                        n+=25;
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent LoadIntent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(LoadIntent);
                    finish();
                }
            }
        };
        thread.start();
    }
      //  Intent homeintent= new Intent(MainActivity.this,HomeActivity.class);
       // startActivity(homeintent);
//
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    */
    }

