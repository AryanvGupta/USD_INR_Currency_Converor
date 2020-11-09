package com.example.usdtoinr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText rupees,dollars;
    private Button camapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rupees = (EditText) findViewById(R.id.rupees);
        dollars = (EditText) findViewById(R.id.dollars);
        //camapp = (Button) findViewById(R.id.button);
        rupees.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(rupees.isFocused())
                    if(!TextUtils.isEmpty(rupees.getText()))
                        dollars.setText(String.valueOf(Float.parseFloat(rupees.getText().toString())*0.014));
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        dollars.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(dollars.isFocused())
                    if(!TextUtils.isEmpty(dollars.getText()))
                        rupees.setText(String.valueOf(Float.parseFloat(dollars.getText().toString())*73.9));
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}