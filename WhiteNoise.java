package com.anderson.bryce.fidgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class WhiteNoise extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_noise);
        final MediaPlayer STATIC1 = MediaPlayer.create(this, R.raw.static1);
        final MediaPlayer STATIC2 = MediaPlayer.create(this, R.raw.static2);
        final MediaPlayer STATIC3 = MediaPlayer.create(this, R.raw.static3);
        final MediaPlayer STATIC4 = MediaPlayer.create(this, R.raw.static4);

        Button playStatic1 = (Button) this.findViewById(R.id.play_static1);
        Button playStatic2 = (Button) this.findViewById(R.id.play_static2);
        Button playStatic3 = (Button) this.findViewById(R.id.play_static3);
        Button playStatic4 = (Button) this.findViewById(R.id.play_static4);

        playStatic1.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                STATIC1.start();
                STATIC2.stop();
                STATIC3.stop();
                STATIC4.stop();
            }
        });

        playStatic2.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                STATIC1.stop();
                STATIC2.start();
                STATIC3.stop();
                STATIC4.stop();
            }
        });

        playStatic3.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                STATIC1.stop();
                STATIC2.stop();
                STATIC3.start();
                STATIC4.stop();
            }
        });

        playStatic4.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                STATIC1.stop();
                STATIC2.stop();
                STATIC3.stop();
                STATIC4.start();
            }
        });
    }


}
