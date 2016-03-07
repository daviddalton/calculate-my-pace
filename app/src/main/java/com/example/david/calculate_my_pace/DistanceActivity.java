package com.example.david.calculate_my_pace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class DistanceActivity extends AppCompatActivity {

    EditText editMinutes;
    EditText editHours;
    EditText editSeconds;
    TextView textDistance;
    EditText editPace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        editMinutes = (EditText) findViewById(R.id.minutes);
        editHours = (EditText) findViewById(R.id.hours);
        editSeconds = (EditText) findViewById(R.id.seconds);
        textDistance = (TextView) findViewById(R.id.distance);
        editPace = (EditText) findViewById(R.id.pace);

        Button button = (Button) findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GregorianCalendar();
                calculate();
            }

        });
    }

    public void GregorianCalendar() {

    }

    public void calculate() {

        double hours = 0;
        double minutes = 0;
        double seconds = 0;
        double pace = 0;

        if (!editSeconds.getText().toString().equals("")) {
            seconds = secondsToMinutes();
        }
        if (!editHours.getText().toString().equals("")) {
            hours = hoursToMinutes();
        }
        if (!editMinutes.getText().toString().equals("")) {
            minutes = Integer.parseInt(editMinutes.getText().toString());
        }
        if (!editPace.getText().toString().equals("")) {
            pace = Integer.parseInt(editPace.getText().toString());
            // take the integer and turn into date
        }

        if (!editSeconds.getText().toString().equals("") && !editHours.getText().toString().equals("") && !editMinutes.getText().toString().equals("") && !editPace.getText().toString().equals("")) {
            double totalMinutes = hours + minutes + seconds;
            double distance = pace / totalMinutes;
            textDistance.setText(String.valueOf(distance));
        }
    }

    private int hoursToMinutes() {
        int hours = Integer.parseInt(editHours.getText().toString());
        return hours / 60;
    }

    private int secondsToMinutes() {
        int seconds = Integer.parseInt(editSeconds.getText().toString());
        return seconds * 60;
    }

}
