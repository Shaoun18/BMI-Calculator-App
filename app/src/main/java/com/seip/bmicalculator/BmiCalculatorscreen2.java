package com.seip.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BmiCalculatorscreen2 extends AppCompatActivity {
    TextView totalresult;
    TextView find;
    Button find1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_bmi_calculatorscreen2);

        totalresult = findViewById(R.id.bmiscore);
        find = findViewById(R.id.result);
        find1 = findViewById(R.id.button);

        Intent intent = getIntent();
        final double result = intent.getDoubleExtra("calculate",0.0);

        totalresult.setText(result+"");
        finalresult(result);

        find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(BmiCalculatorscreen2.this,BMICalculatorscreen3.class);
                startActivity(intent1);
            }
        });
    }

    private void finalresult(double bmi) {

        String condition = "";
        if(bmi <= 18.5){
            condition = "underweight";
            find.setText(condition);

        }else if(bmi >= 18.5 && bmi < 24.5){
            condition = "normal";
            find.setText(condition);
        }else if(bmi >= 25 && bmi < 29.9){
            condition = "overweight";
            find.setText(condition);
        }else{
            condition = "very overweight";
            find.setText(condition);
        }

    }
}