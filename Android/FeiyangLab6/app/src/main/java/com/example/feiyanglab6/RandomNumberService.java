package com.example.feiyanglab6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Random;

//import static com.example.feiyanglab6.MainActivity.isServiceBound;


public class RandomNumberService extends Service {
    int myRandomNumber;
    char a;
    boolean isRandomGeneratorOn;

    final int MIN = 65;
    final int MAX = 90;

    final String TAG = "RandomLetter Service: ";

    class RandomNumberServiceBinder extends Binder{
        public RandomNumberService getService()
        {
            return RandomNumberService.this;
        }
    }

    IBinder myBinder = new RandomNumberServiceBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "In OnStartCommand Thread ID is "+Thread.currentThread().getId());
        isRandomGeneratorOn = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomGenerator();
            }
        }
        ).start();

        return START_STICKY;
    }

    private void startRandomGenerator()
    {
        while(isRandomGeneratorOn){
            try {
                Thread.sleep(1000);
                if(isRandomGeneratorOn){
                    myRandomNumber = MIN + new Random().nextInt(MAX - MIN);
                    a = (char) myRandomNumber;
                    Log.i(TAG, "Thread ID is "+Thread.currentThread().getId() + ", Random letter is " + a);
                    Intent serviceIntent = new Intent();
                    serviceIntent.setAction("com.example.MyService");
                    serviceIntent.putExtra("character", a);
                    sendBroadcast(serviceIntent);
                    //context.startService(serviceIntent);
                }
            }catch(InterruptedException e) {
                Log.i(TAG, "Thread Interrupted.");
            }
        }

    }

    public void stopRandomGenerator()
    {
        isRandomGeneratorOn = false;
    }

    public char getRandomNumber()
    {
        return a;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomGenerator();
        Log.i(TAG, "Service Destroyed.");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        /*if (isServiceBound == true) {
            Log.i(TAG, "In onBind ...");
            return myBinder;
        }else{
            Log.i(TAG, "Service not found ...");*/
            return myBinder;
       /* }*/
    }
}
