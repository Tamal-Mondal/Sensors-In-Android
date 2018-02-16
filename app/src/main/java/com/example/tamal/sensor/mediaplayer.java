package com.example.tamal.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class mediaplayer extends AppCompatActivity implements SensorEventListener {

    TextView t1;

    Sensor s1;

    SensorManager sm;

    public boolean isRunning = false;

    MediaPlayer mp;

    float acelval, acellast, shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s1=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, s1, SensorManager.SENSOR_DELAY_FASTEST);

        t1=(TextView)findViewById(R.id.t1);

        acelval = SensorManager.GRAVITY_EARTH;
        acellast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        acellast = acelval;
        acelval = (float)Math.sqrt((double)(x*x + y*y + z*z));
        float d = acelval -acellast ;
        shake = shake*0.9f + d;
        t1.setText(Float.toString(acelval));

        if(shake>12 && isRunning==false)
        {
            isRunning = true;
            try {

                Random rand = new Random();
                int i = rand.nextInt(5);

                mp =new MediaPlayer();
                if(i==0)
                {
                    mp.setDataSource("https://s1.vocaroo.com/media/download_temp/Vocaroo_s1IgjP1TWkrt.mp3");
                }
                else if(i==1)
                {
                    // Add another url
                    mp.setDataSource("https://s1.vocaroo.com/media/download_temp/Vocaroo_s1IgjP1TWkrt.mp3");
                }
                else if(i==2)
                {
                    // Add another url
                    mp.setDataSource("https://s1.vocaroo.com/media/download_temp/Vocaroo_s1IgjP1TWkrt.mp3");
                }
                else if(i==3)
                {
                    // Add another url
                    mp.setDataSource("https://s1.vocaroo.com/media/download_temp/Vocaroo_s1IgjP1TWkrt.mp3");
                }
                else if(i==4)
                {
                    // Add another url
                    mp.setDataSource("https://s1.vocaroo.com/media/download_temp/Vocaroo_s1IgjP1TWkrt.mp3");
                }
                mp.prepare();
                mp.start();
       //         Toast.makeText(this, "Sensor On", Toast.LENGTH_SHORT).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this, "Error in playing song", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,s1,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onBackPressed() {
        isRunning = false;
        mp.stop();
        super.onBackPressed();
    }
}
