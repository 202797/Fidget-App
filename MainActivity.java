package com.anderson.bryce.fidgetapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ACTIVITIES));
        getListView().setTextFilterEnabled(true);
    }

    static final String[] ACTIVITIES = new String[]{"Vibrations", "White Noise", "Dot Shuffling", "Dials & Sliders"};

    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Intent intent = null;

        if (position == 0)
        {
            intent = new Intent(this, Vibrations.class);
        }
        else if (position == 1)
        {
             intent = new Intent(this, WhiteNoise.class);
        }
        else if (position == 2)
        {
             intent = new Intent(this, DotShuffling.class);
        }
        else if (position == 3)
        {
             intent = new Intent(this, DialsAndSliders.class);
        }

        if (intent != null)
        {
            startActivity(intent);
        }
    }
}
