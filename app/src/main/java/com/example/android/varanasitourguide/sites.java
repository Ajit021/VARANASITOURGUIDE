package com.example.android.varanasitourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class sites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //creating the arraylist to store dynamically
        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.newkashi), R.drawable.ic_newkashi,getString(R.string.newkashi1)));
        places.add(new Place(getString(R.string.bharatkala), R.drawable.ic_bharatkala,getString(R.string.bharatkala1)));
        places.add(new Place(getString(R.string.chaukhandi), R.drawable.ic_chaukhandi,getString(R.string.chaukhandi1)));
        places.add(new Place(getString(R.string.gyanvapi), R.drawable.ic_gyanvapi,getString(R.string.gyanvapi1)));

        //Custom adapter
        PlaceAdapter Adapter = new PlaceAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
                Place place = places.get(postion);


                Intent intent = new Intent(sites.this, info.class);
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
