package com.example.android.varanasitourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class history extends AppCompatActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //creating the arraylist to store dynamically
        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.ramnagar), R.drawable.ic_ramnagar,getString(R.string.ramnagar1)));
        places.add(new Place(getString(R.string.Manikarnika), R.drawable.ic_manikarnika,getString(R.string.Manikarnika1)));
        places.add(new Place(getString(R.string.kashitemple), R.drawable.ic_kashi,getString(R.string.kashitemple1)));
        places.add(new Place(getString(R.string.Darbhanga), R.drawable.ic_darbhanga,getString(R.string.Darbhanga1)));
        places.add(new Place(getString(R.string.Panchganga), R.drawable.ic_panchganga,getString(R.string.Panchganga1)));

        //Custom adapter
        PlaceAdapter Adapter = new PlaceAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
                //to get the position
                Place place = places.get(postion);


                Intent intent = new Intent(history.this, info.class);
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
