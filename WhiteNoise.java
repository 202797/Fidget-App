package com.anderson.bryce.fidgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

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

        final ToggleButton playStatic1 = (ToggleButton) this.findViewById(R.id.play_static1);
        final ToggleButton playStatic2 = (ToggleButton) this.findViewById(R.id.play_static2);
        final ToggleButton playStatic3 = (ToggleButton) this.findViewById(R.id.play_static3);
        final ToggleButton playStatic4 = (ToggleButton) this.findViewById(R.id.play_static4);

        playStatic1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() //switches units on toggle
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (playStatic1.isChecked())
                {
                    STATIC1.start();
                    playStatic2.setChecked(false);
                    playStatic3.setChecked(false);
                    playStatic4.setChecked(false);
                }
                else
                {
                    STATIC1.stop();
                    STATIC1.prepareAsync();
                }
            }
        });

        playStatic2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() //switches units on toggle
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (playStatic2.isChecked())
                {
                    STATIC2.start();
                    playStatic1.setChecked(false);
                    playStatic3.setChecked(false);
                    playStatic4.setChecked(false);
                }
                else
                {
                    STATIC2.stop();
                    STATIC2.prepareAsync();
                }
            }
        });

        playStatic3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() //switches units on toggle
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (playStatic3.isChecked())
                {
                    STATIC3.start();
                    playStatic1.setChecked(false);
                    playStatic2.setChecked(false);
                    playStatic4.setChecked(false);
                }
                else
                {
                    STATIC3.stop();
                    STATIC3.prepareAsync();
                }
            }
        });

        playStatic4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() //switches units on toggle
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (playStatic4.isChecked())
                {
                    STATIC4.start();
                    playStatic1.setChecked(false);
                    playStatic2.setChecked(false);
                    playStatic3.setChecked(false);
                }
                else
                {
                    STATIC4.stop();
                    STATIC4.prepareAsync();
                }
            }
        });
    }


}
