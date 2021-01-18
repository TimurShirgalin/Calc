package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String keyOperations = "Operations";
    public TextView textView;
    private Operations operations = new Operations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        initButtons();
    }

    @Override
    public void onClick(View view) {
        digits(view);
        switch (view.getId()) {
            case R.id.button_4:     //сложить
                doOperation();
                operations.setIdentify_operation(1);
                break;
            case R.id.button_8:     //вычесть
                doOperation();
                operations.setIdentify_operation(2);
                break;
            case R.id.button_12:     //умножить
                doOperation();
                operations.setIdentify_operation(3);
                break;
            case R.id.button_15:     //backSpace
                if (!textView.getText().toString().equals("")) {
                    textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
                }
                break;
            case R.id.button_16:     //разделить
                doOperation();
                operations.setIdentify_operation(4);
                break;
            case R.id.button_17:
                erase();
                break;
            case R.id.button_18:
                setNumber2();
                operations.result();
                textView.setText(Double.toString(operations.getResult()));
                operations.setWhichButton(2);
                break;
        }
    }

    private void doOperation() {
        if (operations.getWhichButton() != 1) {
            if (operations.getSet() == 1) {
                setNumber1();
            } else {
                setNumber2();
                if (operations.getWhichButton() != 55) {
                    operations.result();
                    textView.setText(Double.toString(operations.getResult()));
                }
            }
        }
        operations.setWhichButton(1);
    }

    private void setNumber1() {
        if (!textView.getText().toString().equals("")) {
            operations.setNumber1(Double.parseDouble(textView.getText().toString()));
        }
    }

    private void setNumber2() {
        if (!textView.getText().toString().equals("")) {
            operations.setNumber2(Double.parseDouble(textView.getText().toString()));
        }
    }

    private void check() {
        switch (operations.getWhichButton()) {
            case 0:
                break;
            case 2:
                erase();
                break;
            default:
                textView.setText(null);
                operations.setWhichButton(0);
                break;
        }
    }

    public void digits(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                check();
                textView.append("1");
                break;
            case R.id.button_2:
                check();
                textView.append("2");
                break;
            case R.id.button_3:
                check();
                textView.append("3");
                break;
            case R.id.button_5:
                check();
                textView.append("4");
                break;
            case R.id.button_6:
                check();
                textView.append("5");
                break;
            case R.id.button_7:
                check();
                textView.append("6");
                break;
            case R.id.button_9:
                check();
                textView.append("7");
                break;
            case R.id.button_10:
                check();
                textView.append("8");
                break;
            case R.id.button_11:
                check();
                textView.append("9");
                break;
            case R.id.button_13:
                check();
                if (!textView.getText().toString().contains(".")) {
                    textView.append(".");
                }
                break;
            case R.id.button_14:
                check();
                textView.append("0");
                break;
        }
    }

    private void initButtons() {
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button10 = findViewById(R.id.button_10);
        Button button11 = findViewById(R.id.button_11);
        Button button12 = findViewById(R.id.button_12);
        Button button13 = findViewById(R.id.button_13);
        Button button14 = findViewById(R.id.button_14);
        Button button15 = findViewById(R.id.button_15);
        Button button16 = findViewById(R.id.button_16);
        Button button17 = findViewById(R.id.button_17);
        Button button18 = findViewById(R.id.button_18);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
        button18.setOnClickListener(this);
    }

    private void erase() {
        textView.setText(null);
        operations.setNumber1(0);
        operations.setNumber2(0);
        operations.setResult(0);
        operations.setSet(1);
        operations.setIdentify_operation(0);
        operations.setWhichButton(0);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        operations = (Operations) savedInstanceState.getParcelable(keyOperations);
        setCurrentDigital();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        operations.setCurrentDigital(textView.getText().toString());
        super.onSaveInstanceState(outState);
        outState.putParcelable(keyOperations, operations);
    }

    private void setCurrentDigital() {
        textView.setText(operations.getCurrentDigital());
    }
}