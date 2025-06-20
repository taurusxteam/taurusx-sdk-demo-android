package com.taurusx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.taurusx.tax.api.OnTaurusXInterstitialListener;
import com.taurusx.tax.api.TaurusXAdError;
import com.taurusx.tax.api.TaurusXInterstitialAds;

public class InterstialActivity extends Activity {
    private TaurusXInterstitialAds mTaurusXInterstitialAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstial);

        Button loadBtn = findViewById(R.id.load);
        Button showBtn = findViewById(R.id.show);
        showBtn.setEnabled(false);

        loadBtn.setOnClickListener(v -> {
            mTaurusXInterstitialAds = new TaurusXInterstitialAds(this);
            mTaurusXInterstitialAds.setAdUnitId(Constants.INTERSTITIALID);
            mTaurusXInterstitialAds.loadInterstitial();
            mTaurusXInterstitialAds.setListener(new OnTaurusXInterstitialListener() {
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
                public void onAdFailedToLoad(TaurusXAdError adError) {
                    Toast.makeText(getApplicationContext(), "interstitial ads load error : " + adError,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdShowFailed(TaurusXAdError adError) {
                }
            });
        });

        showBtn.setOnClickListener(v -> {
            if (mTaurusXInterstitialAds != null && mTaurusXInterstitialAds.isReady()) {
                mTaurusXInterstitialAds.show();
                showBtn.setEnabled(false);
            }
        });

    }
}
