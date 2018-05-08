package com.anderson.bryce.fidgetapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class Vibrations extends Activity
{
    private Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrations);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() 
        {

            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            public void onClick(View v)
            {
                if (v == button1)
                {
                    vibrator.vibrate(300000);
                }
                else
                {
                    vibrator.cancel();
                }
            }
        });

    }
}
