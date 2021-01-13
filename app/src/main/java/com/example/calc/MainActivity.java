package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        initButtons();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                textView.append("1");
                break;
            case R.id.button_2:
                textView.append("2");
                break;
            case R.id.button_3:
                textView.append("3");
                break;
            case R.id.button_5:
                textView.append("4");
                break;
            case R.id.button_6:
                textView.append("5");
                break;
            case R.id.button_7:
                textView.append("6");
                break;
            case R.id.button_9:
                textView.append("7");
                break;
            case R.id.button_10:
                textView.append("8");
                break;
            case R.id.button_11:
                textView.append("9");
                break;
            case R.id.button_13:
                textView.append(",");
                break;
            case R.id.button_14:
                textView.append("0");
                break;
        }
    }

    private void initButtons() {
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button9 = findViewById(R.id.button_9);
        Button button10 = findViewById(R.id.button_10);
        Button button11 = findViewById(R.id.button_11);
        Button button13 = findViewById(R.id.button_13);
        Button button14 = findViewById(R.id.button_14);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
    }

}