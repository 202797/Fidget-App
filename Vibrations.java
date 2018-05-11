package com.anderson.bryce.fidgetapp;

//import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;


public class Vibrations extends AppCompatActivity
{
 //   Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //this is what is crashing the app
    private int vibe = 300000;
    long l = vibe;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrations);
    }

    public boolean onTouchEvent(MotionEvent event)
    {


        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(300000);
        }
        else
        {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).cancel();
        }

        return true;

    }// end of onTouchEvent

}
