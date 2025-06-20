package com.taurusx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.taurusx.tax.api.OnTaurusXBannerListener;
import com.taurusx.tax.api.TaurusXAdError;
import com.taurusx.tax.api.TaurusXBannerAds;
import com.taurusx.tax.core.AdSize;

public class BannerActivity extends Activity {
    private TaurusXBannerAds mTaurusXBannerAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        Button loadBtn = findViewById(R.id.load);
        Button loadB2tn = findViewById(R.id.load2);
        FrameLayout view = findViewById(R.id.view);

        loadBtn.setOnClickListener(v -> {
            mTaurusXBannerAds = new TaurusXBannerAds(this);
            mTaurusXBannerAds.setAdUnitId(Constants.BANNERID);
            mTaurusXBannerAds.setAdSize(AdSize.Banner_320_50);
            mTaurusXBannerAds.loadBanner();
            mTaurusXBannerAds.setListener(new OnTaurusXBannerListener() {
                @Override
                public void onAdLoaded() {
                    if (mTaurusXBannerAds != null) {
                        view.removeAllViews();
                        view.addView(mTaurusXBannerAds.getAdView());
                    }
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
                    Toast.makeText(getApplicationContext(), "banner ads load error : " + adError,
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
        loadB2tn.setOnClickListener(v -> {
            mTaurusXBannerAds = new TaurusXBannerAds(this);
            mTaurusXBannerAds.setAdUnitId(Constants.MRECID);
            mTaurusXBannerAds.setAdSize(AdSize.Banner_300_250);
            mTaurusXBannerAds.loadBanner();
            mTaurusXBannerAds.setListener(new OnTaurusXBannerListener() {
                @Override
                public void onAdLoaded() {
                    if (mTaurusXBannerAds != null) {
                        view.removeAllViews();
                        view.addView(mTaurusXBannerAds.getAdView());
                    }
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
                    Toast.makeText(getApplicationContext(), "banner ads load error : " + adError,
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
