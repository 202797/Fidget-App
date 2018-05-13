package com.anderson.bryce.fidgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class DotShuffling extends AppCompatActivity implements SensorEventListener
{
    private Sensor mySensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_shuffling);

        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        TextView dot1 = (TextView) findViewById(R.id.dot1);
        TextView dot2 = (TextView) findViewById(R.id.dot2);
        TextView dot3 = (TextView) findViewById(R.id.dot3);
        TextView dot4 = (TextView) findViewById(R.id.dot4);
        TextView dot5 = (TextView) findViewById(R.id.dot5);
        TextView dot6 = (TextView) findViewById(R.id.dot6);
        TextView dot7 = (TextView) findViewById(R.id.dot7);
        TextView dot8 = (TextView) findViewById(R.id.dot8);
        TextView dot9 = (TextView) findViewById(R.id.dot9);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        event.values[0];
    }
}
