package com.example.david.calculate_my_pace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editMinutes;
    EditText editHours;
    EditText editSeconds;
    EditText editDistance;
    TextView textPace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMinutes = (EditText) findViewById(R.id.minutes);
        editHours = (EditText) findViewById(R.id.hours);
        editSeconds = (EditText) findViewById(R.id.seconds);
        editDistance = (EditText) findViewById(R.id.distance);
        textPace = (TextView) findViewById(R.id.pace);

        Button button = (Button) findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }

        });
    }

    public void calculate() {

        double hours = 0;
        double minutes = 0;
        double seconds = 0;
        double distance = 0;



        if (!editSeconds.getText().toString().equals("")) {
            seconds = Integer.parseInt(editSeconds.getText().toString());
        }
        if (!editHours.getText().toString().equals("")) {
            hours = hoursToSeconds();
        }
        if (!editMinutes.getText().toString().equals("")) {
            minutes = minutesToSeconds();
        }
        if (!editDistance.getText().toString().equals("")) {
            distance = Double.parseDouble(editDistance.getText().toString());
        }

        if (!editSeconds.getText().toString().equals("") && !editHours.getText().toString().equals("") && !editMinutes.getText().toString().equals("") && !editDistance.getText().toString().equals("")) {
            double totalSeconds = hours + minutes + seconds;
            double pace = totalSeconds / distance;
            textPace.setText(DateUtils.formatElapsedTime((long) pace));
        }
    }

    private int minutesToSeconds() {
        int minutes = Integer.parseInt(editMinutes.getText().toString());
        return minutes * 60;
    }

    private int hoursToSeconds() {
        int hours = Integer.parseInt(editHours.getText().toString());
        return hours * 3600;
    }

}