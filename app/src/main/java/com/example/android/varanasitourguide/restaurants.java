package com.example.android.varanasitourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //creating the arraylist to store dynamically
        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.Annapurna), R.drawable.ic_annapurna,getString(R.string.Annapurna1)));
        places.add(new Place(getString(R.string.varanasi), R.drawable.ic_varnasicafe,getString(R.string.varanasi1)));
        places.add(new Place(getString(R.string.canton), R.drawable.ic_canton,getString(R.string.canton1)));
        places.add(new Place(getString(R.string.ganpati), R.drawable.ic_ganpati,getString(R.string.ganpati1)));

        //Custom adapter

        PlaceAdapter Adapter = new PlaceAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
                Place place = places.get(postion);


                Intent intent = new Intent(restaurants.this, info.class);
                intent.putExtra("location",place.getmLocationInfo());
                intent.putExtra("image",place.getmImageResourceId());
                intent.putExtra("details",place.getmDetails());
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
