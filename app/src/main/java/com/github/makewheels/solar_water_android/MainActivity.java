package com.github.makewheels.solar_water_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.hutool.http.HttpUtil;

public class MainActivity extends AppCompatActivity {
    private Button c_stop;
    private Button c_test;
    private Button c_10s;
    private Button c_15s;
    private Button c_1m;
    private Button c_5m;
    private Button c_10m;
    private Button c_15m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c_stop = findViewById(R.id.c_stop);
        c_test = findViewById(R.id.c_test);
        c_10s = findViewById(R.id.c_10s);
        c_15s = findViewById(R.id.c_15s);
        c_1m = findViewById(R.id.c_1m);
        c_5m = findViewById(R.id.c_5m);
        c_10m = findViewById(R.id.c_10m);
        c_15m = findViewById(R.id.c_15m);
        addClickListeners();
    }

    private void addClickListeners() {
        String baseUrl = "https://http-solar-ibtoyhpgjm.cn-beijing.fcapp.run?connectTimeLengthInSeconds=";
        c_stop.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 0);
            runOnUiThread(() -> Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show());
        }).start());
        c_test.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 1500);
            runOnUiThread(() -> Toast.makeText(this, "1.5秒", Toast.LENGTH_SHORT).show());
        }).start());
        c_10s.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 10000);
            runOnUiThread(() -> Toast.makeText(this, "10秒", Toast.LENGTH_SHORT).show());
        }
        ).start());
        c_15s.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 15000);
            runOnUiThread(() -> Toast.makeText(this, "15秒", Toast.LENGTH_SHORT).show());
        }).start());
        c_1m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 60000);
            runOnUiThread(() -> Toast.makeText(this, "1分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_5m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 300000);
            runOnUiThread(() -> Toast.makeText(this, "5分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_10m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 600000);
            runOnUiThread(() -> Toast.makeText(this, "10分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_15m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(baseUrl + 900000);
            runOnUiThread(() -> Toast.makeText(this, "15分钟", Toast.LENGTH_SHORT).show());
        }).start());
    }
}