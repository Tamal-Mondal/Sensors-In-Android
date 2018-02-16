package com.example.tamal.sensor;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.List;

public class linegraph extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "linegraph";
    private SensorManager sm;
    private Sensor s;
    private Thread t;
    private boolean plot = true;
    private LineChart c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linegraph);

        sm =(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        if(s!=null)
        {
            sm.registerListener(this, s, SensorManager.SENSOR_DELAY_GAME);
        }
        else
        {
            Toast.makeText(this, "Sensor Not present", Toast.LENGTH_SHORT).show();
        }

        c=(LineChart)findViewById(R.id.chart);

        c.getDescription().setEnabled(true);
        c.getDescription().setText("Real Time Accelerometer Data Plot");

        c.setTouchEnabled(true);
        c.setDragEnabled(true);
        c.setScaleEnabled(true);
        c.setDrawGridBackground(false);
        c.setPinchZoom(true);
        c.setBackgroundColor(Color.WHITE);

        LineData d = new LineData();
        d.setValueTextColor(Color.WHITE);
        c.setData(d);

        Legend l = c.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);


        XAxis xl = c.getXAxis();
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(true);
        xl.setAvoidFirstLastClipping(true);
        xl.setEnabled(true);

        YAxis yl = c.getAxisLeft();
        yl.setTextColor(Color.WHITE);
        yl.setDrawGridLines(false);
        yl.setAxisMaximum(10f);
        yl.setAxisMinimum(-10f);
        yl.setDrawGridLines(true);

        YAxis yr = c.getAxisRight();
        yr.setEnabled(false);

        c.getAxisLeft().setDrawGridLines(false);
        c.getXAxis().setDrawGridLines(false);
        c.setDrawBorders(false);

        startPlot();
    }

    private void startPlot()
    {
        if(t!= null)
        {
            t.interrupt();
        }

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    plot = true;
                    try {
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    private void addEntry(SensorEvent event)
    {
        LineData d = c.getData();

        if(d!= null)
        {
            ILineDataSet set = d.getDataSetByIndex(0);

            if(set == null)
            {
                set = createSet();
                d.addDataSet(set);
            }

            d.addEntry(new Entry(set.getEntryCount(), event.values[0]+5),0);
            d.notifyDataChanged();
            c.notifyDataSetChanged();
      //      c.setMaxVisibleValueCount(150);
            c.setVisibleXRangeMaximum(150);
            c.moveViewToX(d.getEntryCount());
        }

    }

    private LineDataSet createSet()
    {
        LineDataSet set = new LineDataSet(null , "Dynamic Data");
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setLineWidth(3f);
        set.setColor(Color.MAGENTA);
        set.setHighlightEnabled(false);
        set.setDrawValues(false);
        set.setDrawCircles(false);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setCubicIntensity(0.2f);
        return set;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(plot){
            addEntry(sensorEvent);
            plot = false;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {

        sm.unregisterListener(linegraph.this);
        t.interrupt();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(t!= null)
        {
            t.interrupt();
        }
        sm.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_GAME);
    }
}
