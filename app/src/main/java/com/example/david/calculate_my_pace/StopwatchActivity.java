package com.example.david.calculate_my_pace;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private long timeWhenStopped = 0;
    private boolean stopClicked;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
    }

    public void resetButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        TextView secondsText = (TextView) findViewById(R.id.hmsTekst);
        secondsText.setText("0 seconds");
    }

    public void startButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
        stopClicked = false;

    }

    public void stopButtonClick(View v) {
        if (!stopClicked) {
            TextView secondsText = (TextView) findViewById(R.id.hmsTekst);
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            int seconds = (int) timeWhenStopped / 1000;
            secondsText.setText(Math.abs(seconds) + " seconds");
            chronometer.stop();
            stopClicked = true;
        }


    }
}
