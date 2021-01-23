package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Constant {
    private static final String keyOperations = "Operations";
    private static final int REQUEST_CODE = 11;
    public TextView textView;
    private Operations operations = new Operations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        initButtons();
        Button button = findViewById(R.id.button_19);
        button.setOnClickListener(v -> {
            Intent settings = new Intent(MainActivity.this, SwitchLightDark.class);
            settings.putExtra(CODE_SETTINGS, getDelegate().getLocalNightMode());
            startActivityForResult(settings, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            operations.setCode(data.getExtras().getInt(CODE_SETTINGS));
            if (data.getExtras().getInt(CODE_SETTINGS) == 2) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
    }

    @Override
    public void onClick(View view) {
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
            default:
                check();
                textView.append(((Button) view).getText().toString());
                break;
        }
    }

    private void doOperation() {
        if (operations.getWhichButton() != 1) {
            if (operations.getSet() == 1) {
                setNumber1();
            } else {
                setNumber2();
                operations.result();
                textView.setText(Double.toString(operations.getResult()));
            }
        }
        operations.setWhichButton(1);
    }

    private void setNumber1() {
        if (!textView.getText().toString().equals("")) {
            operations.setNumber1(parseDouble(textView.getText().toString()));
        }
    }

    private void setNumber2() {
        if (!textView.getText().toString().equals("")) {
            operations.setNumber2(parseDouble(textView.getText().toString()));
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

    private void initButtons() {
        View[] but = new View[]{findViewById(R.id.button_1), findViewById(R.id.button_2), findViewById(R.id.button_3), findViewById(R.id.button_4), findViewById(R.id.button_5),
                findViewById(R.id.button_6), findViewById(R.id.button_7), findViewById(R.id.button_8), findViewById(R.id.button_9), findViewById(R.id.button_10),
                findViewById(R.id.button_11), findViewById(R.id.button_12), findViewById(R.id.button_13), findViewById(R.id.button_14),
                findViewById(R.id.button_15), findViewById(R.id.button_16), findViewById(R.id.button_17), findViewById(R.id.button_18)};
        for (View view : but) {
            view.setOnClickListener(this);
        }
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