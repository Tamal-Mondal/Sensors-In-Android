package com.example.tamal.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class proximity extends AppCompatActivity implements SensorEventListener
{

    TextView t1;

    Sensor s1;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s1=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, s1, SensorManager.SENSOR_DELAY_FASTEST);

        t1=(TextView)findViewById(R.id.t1);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {

        t1.setText("Distance : "+ sensorEvent.values[0]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}
