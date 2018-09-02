package com.example.android.varanasitourguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class info extends AppCompatActivity {


    String locationinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView text=(TextView) findViewById(R.id.text);
        ImageView image=(ImageView)findViewById(R.id.imageinfo) ;
        TextView text1=(TextView)findViewById(R.id.text2);
        Bundle bundle=getIntent().getExtras();


        if(bundle!=null)
        {
            locationinfo=bundle.getString("location");
            text.setText(locationinfo);


            int imageinfo=bundle.getInt("image");
            image.setImageResource(imageinfo);

            text1.setText(bundle.getString("details"));
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void placemap(View view)
    {
        //to get the location of the place
        String mLocation=locationinfo;

        //open the google map
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+mLocation+", Varanasi");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }


    public void bookcab(View view)
    {
        String mLocation=locationinfo;
        Intent lauchIntent=getPackageManager().getLaunchIntentForPackage("com.olacabs.customer");
        if(lauchIntent!=null) {
            startActivity(lauchIntent);
        }else
        {
            Uri uri =Uri.parse("geo:0,0?q="+mLocation+", Varanasi");
            Intent goToMarket= new Intent(Intent.ACTION_VIEW,uri);
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_MULTIPLE_TASK|Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

            try
            {
                startActivity(goToMarket);
            }
            catch (ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id=com.olacabs.customer")));
            }
        }
    }
}
