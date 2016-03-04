package com.example.david.calculate_my_pace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button paceButton = (Button) findViewById(R.id.pace);

        paceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
            }
        });

        Button distanceButton = (Button) findViewById(R.id.distance);

        distanceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, DistanceActivity.class));
            }
        });

        Button timeButton = (Button) findViewById(R.id.time);

        timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, TimeActivity.class));
            }
        });

        ImageButton button = (ImageButton) findViewById(R.id.imageButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, StopwatchActivity.class));
            }
        });
    }

    
}
