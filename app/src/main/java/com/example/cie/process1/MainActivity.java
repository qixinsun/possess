package com.example.cie.process1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  static Handler mHandler = new Handler();
    private static TextView view = null;
    private static String timeNow;
    private Button start, stop, clear;
    private static String TAG = "try1";

    public static void UpdateGUI(String str){
        timeNow = str;
        mHandler.post(RefreshLable);
    }

    private static Runnable RefreshLable = new Runnable() {
        @Override
        public void run() {
            view.setText(timeNow);
            //Log.d(TAG, "refreshLable" + timeNow, new Exception());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.pause);
        clear = findViewById(R.id.clear);

        final Intent serviceIntent = new Intent(this, TimeService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "start" + timeNow, new Exception());
                view.setText("00:00:00");
                startService(serviceIntent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
                Log.d(TAG, "clear" + timeNow, new Exception());
                view.setText("00:00:00");
            }
        });
    }
}
