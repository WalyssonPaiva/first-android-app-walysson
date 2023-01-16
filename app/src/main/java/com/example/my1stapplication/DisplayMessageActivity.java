package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    EditText num1, num2;
    Button add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    public void calculate(View view) {
        Intent intent = new Intent(this, Result.class);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        switch (view.getId()) {
            case R.id.add:
                intent.putExtra("op", '+');
                break;
            case R.id.sub:
                intent.putExtra("op", '-');
                break;
            case R.id.mul:
                intent.putExtra("op", '*');
                break;
            case R.id.div:
                intent.putExtra("op", '/');
                break;
        }
        intent.putExtra("num1", n1);
        intent.putExtra("num2", n2);
        startActivity(intent);


    }
}