package com.example.android.varanasitourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class topattraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //creating the arraylist to store dynamically
        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.River),R.drawable.ic_ganga,getString(R.string.River1)));
        places.add(new Place(getString(R.string.Bhu), R.drawable.ic_bhu,getString(R.string.Bhu1)));
        places.add(new Place(getString(R.string.Statue), R.drawable.ic_statue,getString(R.string.Statue1)));
        places.add(new Place(getString(R.string.sarnath), R.drawable.ic_sarnath,getString(R.string.sarnath1)));
        places.add(new Place(getString(R.string.Chunar), R.drawable.ic_chunar,getString(R.string.Chunar1)));
        places.add(new Place(getString(R.string.mary), R.drawable.ic_mary,getString(R.string.mary1)));
        places.add(new Place(getString(R.string.Bharat), R.drawable.ic_bharat,getString(R.string.Bharat1)));

        //Custom adapter
        PlaceAdapter Adapter = new PlaceAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
                Place place = places.get(postion);


                Intent intent = new Intent(topattraction.this, info.class);
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

