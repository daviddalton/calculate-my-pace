package com.calculatemypace.david.calculateMyPace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editMinutes;
    EditText editHours;
    EditText editSeconds;
    EditText editDistance;
    TextView textPace;
    Switch converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMinutes = findViewById(R.id.minutes);
        editHours = findViewById(R.id.hours);
        editSeconds = findViewById(R.id.seconds);
        editDistance = findViewById(R.id.distance);
        textPace = findViewById(R.id.pace);
        converter = findViewById(R.id.units_switch);
        converter.setText("miles");

        Button button = findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }

        });

        button = findViewById(R.id.clear_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        converter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled. Display the hint "kilometers"
                    editDistance.setHint("kilo");
                    converter.setText("kilometers");
                } else {
                    // The toggle is disabled. Display the hint "miles"
                    editDistance.setHint("miles");
                    converter.setText("miles");
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void calculate() {

        double hours;
        double minutes;
        double seconds;
        double distanceMile = 0;
        double distanceKilo = 0;
        double kiloConversion = 0.62;


        if (!editSeconds.getText().toString().equals("")) {
            seconds = Integer.parseInt(editSeconds.getText().toString());
        } else {
            seconds = 0;
        }
        if (!editHours.getText().toString().equals("")) {
            hours = hoursToSeconds();
        } else {
            hours = 0;
        }
        if (!editMinutes.getText().toString().equals("")) {
            minutes = minutesToSeconds();
        } else {
            minutes = 0;
        }
        if (!editDistance.getText().toString().equals("")) {
            distanceMile = Double.parseDouble(editDistance.getText().toString());
            distanceKilo = Double.parseDouble(editDistance.getText().toString()) * kiloConversion;
        }

        if (!editDistance.getText().toString().equals("") && editDistance.getHint().equals("miles")) {
            double totalSeconds = hours + minutes + seconds;
            double pace = totalSeconds / distanceMile;
            textPace.setText(DateUtils.formatElapsedTime((long) pace) + " " + "min/mile");
        } else if(!editDistance.getText().toString().equals("")) {
            double totalSeconds = hours + minutes + seconds;
            double pace = totalSeconds / distanceKilo;
            textPace.setText(DateUtils.formatElapsedTime((long) pace) + " " + "min/mile");
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

    public void clear() {
        editDistance.getText().clear();
        editHours.getText().clear();
        editMinutes.getText().clear();
        editSeconds.getText().clear();
        textPace.setText("Your pace will go here...");
    }

}