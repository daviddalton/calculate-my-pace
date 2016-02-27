package com.example.david.calculate_my_pace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editMinutes;
    EditText editHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMinutes = (EditText) findViewById(R.id.minutes);
        editHours = (EditText) findViewById(R.id.hours);

        Button button = (Button) findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate((Button) view);
            }

        });
    }

    public void calculate(Button button) {
        editHours.setText(editMinutes.getText().toString());
    }

}