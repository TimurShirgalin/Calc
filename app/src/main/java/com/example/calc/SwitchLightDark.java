package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SwitchLightDark extends AppCompatActivity implements Constant {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int check = getDelegate().getLocalNightMode();
        if (getIntent().getExtras().getInt(CODE_SETTINGS) == 2 & check == -100) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        setContentView(R.layout.activity_switch_light_dark);
        Button buttonSwitch = findViewById(R.id.button_switch);
        buttonSwitch.setOnClickListener(v -> {
            int check1 = getDelegate().getLocalNightMode();
            if (check1 == 2) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            int f = getDelegate().getLocalNightMode();
        });

        Button button = findViewById(R.id.button_Back_id);
        button.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            intentResult.putExtra(CODE_SETTINGS, SwitchLightDark.this.getDelegate().getLocalNightMode());
            SwitchLightDark.this.setResult(RESULT_OK, intentResult);
            SwitchLightDark.this.finish();
        });
    }

}
