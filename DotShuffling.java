package com.anderson.bryce.fidgetapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.Display;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class DotShuffling extends AppCompatActivity implements SensorEventListener
{
    private CanvasView canvas;

    private float circX;
    private float circY;

    private Timer timer;
    private Handler handler;

    private Sensor accel;
    private SensorManager SM;

    private float sensorX;
    private float sensorY;
    private float sensorZ;

    private long lastSensorUpdateTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_shuffling);

        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);

        final Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        circX = (size.x) / 2;
        circY = (size.y) / 2 - 120;

        canvas = new CanvasView(DotShuffling.this);
        setContentView(canvas);

        handler = new Handler()
        {
            @Override
            public void handleMessage(Message message)
            {
                canvas.invalidate();
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {   //tilt --> = -accel
                if (circX >= display.getWidth() - 30)
                {
                    circX = display.getWidth() - 30;
                    circX -= sensorX;
                }
                if (circX <= 30)
                {
                    circX = 30;
                    circX -= sensorX;
                }
                if (circY >= display.getHeight() - 240)
                {
                    circY = display.getHeight() - 240;
                    circY += sensorY;
                }
                if (circY <= 30)
                {
                    circY = 30;
                    circY += sensorY;
                }
                    circX -= sensorX;
                    circY += sensorY;


                handler.sendEmptyMessage(0);
            }
        }, 0, 10);
    }

    private class CanvasView extends View
    {
        private Paint paint;
        public CanvasView(Context context)
        {
            super(context);
            setFocusable(true);

            paint = new Paint();
        }

        public void onDraw(Canvas canvas)
        {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setTextSize(30f);

            canvas.drawCircle(circX, circY, 30, paint);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastSensorUpdateTime > 100)
            {
                lastSensorUpdateTime = currentTime;
                sensorX = sensorEvent.values[0];
                sensorY = sensorEvent.values[1];
                sensorZ = sensorEvent.values[2];
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
