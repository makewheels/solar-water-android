package com.github.makewheels.solar_water_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.hutool.http.HttpUtil;

public class MainActivity extends AppCompatActivity {
    private Button c_test;
    private Button c_10s;
    private Button c_1m;
    private Button c_5m;
    private Button c_10m;
    private Button c_15m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c_test = findViewById(R.id.c_test);
        c_10s = findViewById(R.id.c_10s);
        c_1m = findViewById(R.id.c_1m);
        c_5m = findViewById(R.id.c_5m);
        c_10m = findViewById(R.id.c_10m);
        c_15m = findViewById(R.id.c_15m);
        addClickListeners();
    }

    private void addClickListeners() {
        String baseUrl = "http://101.42.94.17:5032/connect?timeLength=";
        c_test.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 1500)
        ).start());
        c_10s.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 10000)
        ).start());
        c_1m.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 60000)
        ).start());
        c_5m.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 300000)
        ).start());
        c_10m.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 600000)
        ).start());
        c_15m.setOnClickListener(view -> new Thread(() ->
                HttpUtil.get(baseUrl + 900000)
        ).start());
    }
}