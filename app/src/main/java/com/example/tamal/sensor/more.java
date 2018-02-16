package com.example.tamal.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class more extends AppCompatActivity implements SensorEventListener {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;

    Sensor s1,s2,s3,s4,s5;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);

        s1=sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sm.registerListener( this, s1, SensorManager.SENSOR_DELAY_NORMAL);

        s2=sm.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sm.registerListener( this, s2, SensorManager.SENSOR_DELAY_NORMAL);

        s3=sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener( this, s3, SensorManager.SENSOR_DELAY_NORMAL);

        s4=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener( this, s4, SensorManager.SENSOR_DELAY_NORMAL);

        s5=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener( this, s5, SensorManager.SENSOR_DELAY_NORMAL);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);

        if(s1==null)
        {
            t1.setText("Temperature Sensor is not present");
        }
        if(s2==null)
        {
            t2.setText("Pressure Sensor is not present");
        }
        if(s3==null)
        {
            t3.setText("Gravity Sensor is not present");
        }
        if(s4==null)
        {
            t5.setText("Gyroscope Sensor is not present");
        }
        if(s5==null)
        {
            t8.setText("Magnetic Field Sensor is not present");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            t1.setText(Float.toString(sensorEvent.values[0]));
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_PRESSURE)
        {
            t2.setText(Float.toString(sensorEvent.values[0]));
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_GRAVITY)
        {
            t3.setText(Float.toString(sensorEvent.values[0]));
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_GYROSCOPE)
        {
            t4.setText("X : "+sensorEvent.values[0]);
            t5.setText("Y : "+sensorEvent.values[1]);
            t6.setText("Z : "+sensorEvent.values[2]);
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD)
        {
            t7.setText("X : "+sensorEvent.values[0]);
            t8.setText("Y : "+sensorEvent.values[1]);
            t9.setText("Z : "+sensorEvent.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
