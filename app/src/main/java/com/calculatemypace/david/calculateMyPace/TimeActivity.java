package com.calculatemypace.david.calculateMyPace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {

    TextView textTime;
    EditText editDistance;
    EditText editPace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        editDistance = (EditText) findViewById(R.id.distance);
        editPace = (EditText) findViewById(R.id.pace);
        textTime = (TextView) findViewById(R.id.time);

        Button button = (Button) findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }

        });

    }

    public void calculate() {

    }
}
