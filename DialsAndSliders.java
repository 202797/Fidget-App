package com.anderson.bryce.fidgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class DialsAndSliders extends AppCompatActivity implements OnTouchListener
{
    private ImageView dial1;
    private ImageView dial2;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    private double mCurrAngle2 = 0;
    private double mPrevAngle2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dials_and_sliders);

        dial1=(ImageView)findViewById(R.id.imgView);
        dial1.setOnTouchListener(this);
        dial2=(ImageView)findViewById(R.id.imgView2);
        dial2.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(final View v, MotionEvent event)
    {
        final float xc = dial1.getWidth() / 2;
        final float yc = dial1.getHeight() / 2;

        final float x = event.getX();
        final float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                dial1.clearAnimation();
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                mPrevAngle = mCurrAngle;
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                animate(mPrevAngle, mCurrAngle, 0);
                break;
            }
            case MotionEvent.ACTION_UP :
            {
                mPrevAngle = mCurrAngle = 0;
                break;
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        final float xc2 = dial2.getWidth() / 2;
        final float yc2 = dial2.getHeight() / 2;

        final float x2 = event.getX();
        final float y2 = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                dial2.clearAnimation();
                mCurrAngle2 = Math.toDegrees(Math.atan2(x2 - xc2, yc2 - y2));
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                mPrevAngle2 = mCurrAngle2;
                mCurrAngle2 = Math.toDegrees(Math.atan2(x2 - xc2, yc2 - y2));
                animate2(mPrevAngle2, mCurrAngle2, 0);
                break;
            }
            case MotionEvent.ACTION_UP : {
                mPrevAngle2 = mCurrAngle2 = 0;
                break;
            }
        }
        return true;
    }

    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        dial1.startAnimation(rotate);
    }

   /* public boolean onTouch2(final View v, MotionEvent event) {
        final float xc2 = dial2.getWidth() / 2;
        final float yc2 = dial2.getHeight() / 2;

        final float x2 = event.getX();
        final float y2 = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                dial2.clearAnimation();
                mCurrAngle2 = Math.toDegrees(Math.atan2(x2 - xc2, yc2 - y2));
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                mPrevAngle2 = mCurrAngle2;
                mCurrAngle2 = Math.toDegrees(Math.atan2(x2 - xc2, yc2 - y2));
                animate2(mPrevAngle2, mCurrAngle2, 0);
                break;
            }
            case MotionEvent.ACTION_UP : {
                mPrevAngle2 = mCurrAngle2 = 0;
                break;
            }
        }
        return true;
    }
*/
    private void animate2(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        dial2.startAnimation(rotate);
    }
}

