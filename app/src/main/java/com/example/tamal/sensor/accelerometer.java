package com.example.tamal.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class accelerometer extends AppCompatActivity implements SensorEventListener{

    TextView t1, t2, t3;

    Sensor s1;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s1=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, s1, SensorManager.SENSOR_DELAY_NORMAL);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        t1.setText("X : "+ sensorEvent.values[0]);
        t2.setText("Y : "+ sensorEvent.values[1]);
        t3.setText("Z : "+ sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
