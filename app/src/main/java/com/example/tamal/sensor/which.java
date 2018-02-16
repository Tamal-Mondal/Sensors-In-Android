package com.example.tamal.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class which extends AppCompatActivity implements SensorEventListener {

    TextView t1,t2;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t2.setSingleLine(false);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> sl = sm.getSensorList(Sensor.TYPE_ALL);

        t1.setText(sl.size() + " Sensors I Have!!");

        String sls = new String("");
        Sensor tmp;
        int x,i;
        for (i=0;i<sl.size();i++) {
            tmp = sl.get(i);
            sls = sls + "\n" + tmp.getName();
        }

        if (i>0){
            t2.setText(sls);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
