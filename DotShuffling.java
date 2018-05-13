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
    private float circR = 30;

    private Timer timer;
    private Handler handler;

    private Sensor accel;
    private SensorManager SM;

    private float sensorX;
    private float sensorY;
    private float sensorZ;
    private long interval;
    private double velocityX;
    private double vx = 0;
    private double velocityY;
    private double vy = 0;

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

        circX = (size.x) / 2 - circR;
        circY = (size.y) / 2 - circR;

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
                if (sensorX < 0)
                {
                    circX -= velocityX;
                }
                //tilt <-- = +accel
                else if (sensorX > 0)
                {
                    circX -= velocityX;
                }
                // tilt ^ = +accel
                if (sensorY > 0 && circY < canvas.getHeight() - circR)
                {
                    circY += velocityY;
                }
                //tilt v = -accel
                else if (sensorY < 0 && circY > circR)
                {
                    circY += velocityY;
                }

                if (circX > canvas.getWidth() - circR)
                {
                    circX -= circX - (canvas.getWidth() - circR);
                    velocityX = 0;
                }
                else if (circX < circR)
                {
                    circX += circR - circX;
                    velocityX = 0;
                }

                if (circY > canvas.getHeight() - circR)
                {
                    circY -= circY - (canvas.getHeight() - circR);
                    velocityY = 0;
                }
                else if (circY < circR)
                {
                    circY += circR - circY;
                    velocityY = 0;
                }

                handler.sendEmptyMessage(0);
            }
        }, 0, 1 );
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

            canvas.drawCircle(circX, circY, circR, paint);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            sensorX = sensorEvent.values[0];
            sensorY = sensorEvent.values[1];
            sensorZ = sensorEvent.values[2];
            long currentTime = System.currentTimeMillis();
            interval = currentTime - lastSensorUpdateTime;
            lastSensorUpdateTime = currentTime;
            velocityX = vx + (sensorX*(interval/(double)1000));
            vx = velocityX;
            velocityY = vy + (sensorY*(interval/(double)1000));
            vy = velocityY;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
