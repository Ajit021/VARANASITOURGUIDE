package com.example.android.varanasitourguide;

/**
 * Created by this pc on 8/29/2018.
 */

public class Place {
    private String mLocationInfo;

    private int mImageResourceId;
    private String mdefaultDetails;

    public Place(String defaultLocationInfo,int defaultImageResourceId,String defaultDetails)
    {
        mLocationInfo=defaultLocationInfo;
        mImageResourceId=defaultImageResourceId;
        mdefaultDetails=defaultDetails;
    }

    //return the location
    public String getmLocationInfo()
    {
        return mLocationInfo;
    }

    //return the imageresourceid
    public int getmImageResourceId()
    {
        return mImageResourceId;
    }

    //return details of the place
    public String getmDetails(){ return mdefaultDetails;}


}
