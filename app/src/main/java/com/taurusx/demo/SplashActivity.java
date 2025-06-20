package com.taurusx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.taurusx.tax.api.OnTaurusXAppOpenAdListener;
import com.taurusx.tax.api.TaurusXAdError;
import com.taurusx.tax.api.TaurusXAppOpenAds;

public class SplashActivity extends Activity {
    private TaurusXAppOpenAds mTaurusXAppOpenAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button loadBtn = findViewById(R.id.load);
        Button showBtn = findViewById(R.id.show);
        showBtn.setEnabled(false);

        loadBtn.setOnClickListener(v -> {
            mTaurusXAppOpenAds = new TaurusXAppOpenAds(this);
            mTaurusXAppOpenAds.setAdUnitId(Constants.SPLASHID);
            mTaurusXAppOpenAds.loadAd();
            mTaurusXAppOpenAds.setListener(new OnTaurusXAppOpenAdListener() {
                @Override
                public void onAdLoaded() {
                    showBtn.setEnabled(true);
                }

                @Override
                public void onAdShown() {

                }

                @Override
                public void onAdClicked() {

                }

                @Override
                public void onAdClosed() {

                }

                @Override
                public void onAdFailedToLoad(TaurusXAdError taurusXAdError) {
                    Toast.makeText(getApplicationContext(), "splash ads load error : " + taurusXAdError,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdShowFailed(TaurusXAdError taurusXAdError) {

                }
            });
        });

        showBtn.setOnClickListener(v -> {
            if (mTaurusXAppOpenAds != null && mTaurusXAppOpenAds.isReady()) {
                mTaurusXAppOpenAds.show();
                showBtn.setEnabled(false);
            }
        });

    }
}
