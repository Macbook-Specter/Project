package com.coolweather.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;

import androidx.preference.PreferenceManager;

import com.coolweather.android.gson.Weather;
import com.coolweather.android.until.HttpUtil;
import com.coolweather.android.until.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoUpdateService extends Service {
    @Override
    public IBinder onBind (Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        updateWeather();
        updateBingPic();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHOur = 8 * 60 * 1000 *60;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHOur;
        Intent i = new Intent(this, AutoUpdateService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        manager.cancel(pi);
        return super.onStartCommand(intent, flags, startId);
    }

    //更新每日一图 保存到 SharedPreferences
    private void updateBingPic ( ) {
        String requestBingfPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingfPic, new Callback() {
            @Override
            public void onResponse (Call call, Response response) throws IOException {

                final String bingpic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                editor.putString("bing_pic", bingpic);
                editor.apply();
            }

            @Override
            public void onFailure (Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

    //更新天气  保存到SharedPreferences
    private void updateWeather ( ) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);
        if (weatherString != null) {
            //有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);

            String weatherId = weather.basic.weatherId;

            String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId +
                    "&key=f06c23caa52e45fa89b7cb6e1a752af2";

            HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
                @Override
                public void onResponse (Call call, Response response) throws IOException {

                    String responseText = response.body().string();

                    Weather weather = Utility.handleWeatherResponse(responseText);

                    if (weather != null && "ok".equals(weather.status)) {
                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                        editor.putString("weather", responseText);
                        editor.apply();

                    }
                }

                @Override
                public void onFailure (Call call, IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}