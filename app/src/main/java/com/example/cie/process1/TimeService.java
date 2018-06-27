package com.example.cie.process1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TimeService extends Service {
    private Thread workThread;
    private int time_h=0, time_m=0, time_s=0;
    private String TAG = "try1";
    boolean stopMe = true;
    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(this, "(1)调用onCreate()", Toast.LENGTH_LONG).show();
        workThread = new Thread(null, backgroundWork, "WorkThread");
        Log.d(TAG, "TimeServiceOnCreate",  new Exception());
        stopMe = true;
    }

    @Override
    public void onStart(Intent intent, int startId){
        super.onStart(intent, startId);
        Toast.makeText(this, "(调用onStart()", Toast.LENGTH_LONG).show();
        stopMe = true;
        if(!workThread.isAlive()){
            workThread.start();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "调用onDestroy()", Toast.LENGTH_LONG).show();
        workThread.interrupt();
        stopMe = false;
        Log.d(TAG,"调用destroy");
    }
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    private Runnable backgroundWork = new Runnable() {
        @Override
        public void run() {
            while(stopMe){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    time_s++;
                    if(time_s>=60){
                        time_s=0;
                        time_m++;
                        if(time_m>=60){
                            time_m=0;
                            time_h++;
                            if(time_h>=24){
                                time_h=0;
                            }
                        }
                    }

                //Log.d(TAG, " TimeServiceThread  " + Thread.interrupted(),  new Exception());
                    String str = String.valueOf(time_h) + ":" + String.valueOf(time_m) + ":" + String.valueOf(time_s);
                    MainActivity.UpdateGUI(str);
            }
        }
    };
}
