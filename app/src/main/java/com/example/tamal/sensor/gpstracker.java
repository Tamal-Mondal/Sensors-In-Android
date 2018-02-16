package com.example.tamal.sensor;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class gpstracker extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpstracker);

        b=(Button)findViewById(R.id.b1);
        ActivityCompat.requestPermissions(gpstracker.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gpslocation g = new gpslocation(getApplicationContext());
                Location l = g.findlocation();
                if(l!= null)
                {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(gpstracker.this, lat+"\n"+lon, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
