package com.github.makewheels.solar_water_android;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.alibaba.fastjson2.JSONObject;

import cn.hutool.http.HttpUtil;

public class MainActivity extends AppCompatActivity {
    private TextView tv_device_status;
    private TextView tv_timestamp;

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

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        tv_device_status = findViewById(R.id.tv_device_status);
        tv_timestamp = findViewById(R.id.tv_timestamp);

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

    @Override
    protected void onStart() {
        super.onStart();
        loadDeviceStatus();
    }

    private void addClickListeners() {
        String connectBaseUrl = "https://http-connect-solar-oxjgbdfmab.cn-beijing.fcapp.run?connectTimeLengthInMilliSeconds=";
        c_stop.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 0);
            runOnUiThread(() -> Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show());
        }).start());
        c_test.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 1500);
            runOnUiThread(() -> Toast.makeText(this, "1.5秒", Toast.LENGTH_SHORT).show());
        }).start());
        c_10s.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 10000);
            runOnUiThread(() -> Toast.makeText(this, "10秒", Toast.LENGTH_SHORT).show());
        }
        ).start());
        c_15s.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 15000);
            runOnUiThread(() -> Toast.makeText(this, "15秒", Toast.LENGTH_SHORT).show());
        }).start());
        c_1m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 60000);
            runOnUiThread(() -> Toast.makeText(this, "1分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_5m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 300000);
            runOnUiThread(() -> Toast.makeText(this, "5分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_10m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 600000);
            runOnUiThread(() -> Toast.makeText(this, "10分钟", Toast.LENGTH_SHORT).show());
        }).start());
        c_15m.setOnClickListener(view -> new Thread(() -> {
            HttpUtil.get(connectBaseUrl + 900000);
            runOnUiThread(() -> Toast.makeText(this, "15分钟", Toast.LENGTH_SHORT).show());
        }).start());
    }

    private void loadDeviceStatus() {
        String url = "https://http-gee-status-solar-uucjvfcrmw.cn-beijing.fcapp.run";
        new Thread(() -> {
            JSONObject data = JSONObject.parseObject(HttpUtil.get(url)).getJSONObject("data");
            Log.e("tag", "获取设备在线状态返回：" + data.toJSONString());
            runOnUiThread(() -> {
                tv_device_status.setText("当前状态：" + data.getString("deviceStatus"));
                tv_timestamp.setText("最后上线时间：" + data.getString("timestampString"));
            });
        }).start();
    }
}