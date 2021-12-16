package com.seip.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText weightET, heightET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = findViewById(R.id.weightkg);
        heightET = findViewById(R.id.height);
        Button fab = findViewById(R.id.calculate);
        fab.setOnClickListener(v -> {
            final String weight = weightET.getText().toString();
            final String height = heightET.getText().toString();
            if(weight.isEmpty()){
                weightET.setError("Please Enter valid weight");
                return;
            }
            if(height.isEmpty()){
                heightET.setError("Please Enter height");
                return;
            }
            double a=Double.parseDouble(weight);
            double b=Double.parseDouble(height);
            double s=a/(b*b);
            Intent intent = new Intent(MainActivity.this,BmiCalculatorscreen2.class);
              intent.putExtra("calculate",s);
            startActivity(intent);
        });
    }
}