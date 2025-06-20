package com.taurusx.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.taurusx.tax.api.TaurusXAds;
import com.taurusx.tax.log.LogUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.setLogEnable(true);
        TaurusXAds.init(this, Constants.APPID);

        setContentView(R.layout.activity_main);
        setTitle(getTitle());

        Button banner = findViewById(R.id.banner);
        banner.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BannerActivity.class));
        });

        Button nativeBtn = findViewById(R.id.native_btn);
        nativeBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NativeActivity.class));
        });

        Button interstitialBtn = findViewById(R.id.interstial_btn);
        interstitialBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, InterstialActivity.class));
        });

        Button rewardBtn = findViewById(R.id.reward_btn);
        rewardBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RewardAdActivity.class));
        });

        Button appopenBtn = findViewById(R.id.appopen_btn);
        appopenBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SplashActivity.class));
        });
    }

}
