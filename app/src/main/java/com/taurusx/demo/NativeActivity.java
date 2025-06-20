package com.taurusx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.taurusx.tax.api.OnTaurusXNativeListener;
import com.taurusx.tax.api.TaurusXAdError;
import com.taurusx.tax.api.TaurusXNativeAds;

public class NativeActivity extends Activity {
    private TaurusXNativeAds mTaurusXNativeAds;
    private FrameLayout mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);

        Button loadBtn = findViewById(R.id.load);
        Button showBtn = findViewById(R.id.show);
        showBtn.setEnabled(false);
        mAdView = findViewById(R.id.ad_view);

        loadBtn.setOnClickListener(v -> {
            mTaurusXNativeAds = new TaurusXNativeAds(this);
            mTaurusXNativeAds.setAdUnitId(Constants.NATIVEID);
            mTaurusXNativeAds.loadNative();
            mTaurusXNativeAds.setListener(new OnTaurusXNativeListener() {
                @Override
                public void onAdLoaded(TaurusXNativeAds taurusXNativeAds) {
                    showBtn.setEnabled(true);
                }

                @Override
                public void onAdFailedToLoad(TaurusXAdError adError) {
                    Toast.makeText(getApplicationContext(), "native ads load error : " + adError,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onClicked() {
                }

                @Override
                public void onImpression() {
                }
            });
        });

        showBtn.setOnClickListener(v -> {
            if (mTaurusXNativeAds != null && mTaurusXNativeAds.isReady()) {
                mTaurusXNativeAds.showNative(this, mAdView);
                showBtn.setEnabled(false);
            }
        });
    }
}
