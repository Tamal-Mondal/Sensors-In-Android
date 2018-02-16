package com.example.tamal.sensor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by tamal on 09-02-2018.
 */

public class gpslocation implements LocationListener
{
    Context context;
    public gpslocation(Context c)
    {
        context = c;
    }

    public Location findlocation()
    {
        if (ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            return null;
        }
        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean isenabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isenabled)
        {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,this);
            Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;
        }
        else
        {
            Toast.makeText(context, "Please enable GPS", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
