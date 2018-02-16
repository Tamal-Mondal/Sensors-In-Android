package com.example.tamal.sensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class light extends AppCompatActivity implements SensorEventListener{

    TextView t1;

    LinearLayout sb;

    Sensor s1;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s1=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, s1, SensorManager.SENSOR_DELAY_FASTEST);

        t1=(TextView)findViewById(R.id.t1);
        sb=(LinearLayout)findViewById(R.id.sb);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        float lux = sensorEvent.values[0];
        t1.setText("Light : "+ lux);
        if(lux>1000)
        {
            t1.setBackgroundColor(Color.BLACK);
            t1.setTextColor(Color.WHITE);
            sb.setBackgroundColor(Color.BLACK);
        }
        else if(lux>800)
        {
            t1.setBackgroundColor(Color.MAGENTA);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.MAGENTA);
        }
        else if(lux>600)
        {
            t1.setBackgroundColor(Color.WHITE);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.WHITE);
        }
        else if(lux>400)
        {
            t1.setBackgroundColor(Color.CYAN);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.CYAN);
        }
        else if(lux>200)
        {
            t1.setBackgroundColor(Color.GRAY);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.GRAY);
        }
        else if(lux>150)
        {
            t1.setBackgroundColor(Color.GREEN);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.GREEN);
        }
        else if(lux>100)
        {
            t1.setBackgroundColor(Color.YELLOW);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.YELLOW);
        }
        else if(lux>50)
        {
            t1.setBackgroundColor(Color.BLUE);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.BLUE);
        }
        else
        {
            t1.setBackgroundColor(Color.RED);
            t1.setTextColor(Color.BLACK);
            sb.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}
