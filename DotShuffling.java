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
    TextView dot1;
    TextView dot2;
    TextView dot3;
    TextView dot4;
    TextView dot5;

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

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        dot1.setX(dot1.getX() + event.values[0]);
        dot1.setY(dot1.getY() + event.values[1]);

        dot2.setX(dot2.getX() + event.values[0]);
        dot2.setY(dot2.getY() + event.values[1]);

        dot3.setX(dot3.getX() + event.values[0]);
        dot3.setY(dot3.getY() + event.values[1]);

        dot4.setX(dot4.getX() + event.values[0]);
        dot4.setY(dot4.getY() + event.values[1]);

        dot5.setX(dot5.getX() + event.values[0]);
        dot5.setY(dot5.getY() + event.values[1]);
    }
}
