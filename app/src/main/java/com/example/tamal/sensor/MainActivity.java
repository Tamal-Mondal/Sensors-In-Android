package com.example.tamal.sensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button b1,b2,b3,b4,b5,b6,b7,b8;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
    }

    public void accelerometer(View view)
    {
        Intent i = new Intent(this, accelerometer.class);
        startActivity(i);
    }

    public void proxy(View view)
    {
        Intent i = new Intent(this, proximity.class);
        startActivity(i);
    }

    public void light(View view)
    {
        Intent i = new Intent(this, light.class);
        startActivity(i);
    }

    public void linegraph(View view)
    {
        Intent i = new Intent(this, linegraph.class);
        startActivity(i);
    }

    public void media(View view)
    {
        Intent i = new Intent(this, mediaplayer.class);
        startActivity(i);
    }

    public void which(View view)
    {
        Intent i = new Intent(this, which.class);
        startActivity(i);
    }

    public void  gpstrack(View view)
    {
        Intent i = new Intent(this, gpsloc.class);
        startActivity(i);
    }

    public void  moresensors(View view)
    {
        Intent i = new Intent(this, more.class);
        startActivity(i);
    }
}
