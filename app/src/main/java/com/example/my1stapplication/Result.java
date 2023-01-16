package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double result = calculate(intent.getDoubleExtra("num1", 0), intent.getDoubleExtra("num2", 0),
                intent.getCharExtra("op", '+'));

        TextView textView = findViewById(R.id.showResult);
        textView.setText(String.valueOf(result));
    }

    public double calculate(double a, double b, char op) {
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        return result;
    }
}