package com.taurusx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.taurusx.tax.api.OnTaurusXRewardListener;
import com.taurusx.tax.api.TaurusXAdError;
import com.taurusx.tax.api.TaurusXRewardedAds;

public class RewardAdActivity extends Activity {
    private TaurusXRewardedAds mTaurusXRewardedAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        Button loadBtn = findViewById(R.id.load);
        Button showBtn = findViewById(R.id.show);
        showBtn.setEnabled(false);

        loadBtn.setOnClickListener(v -> {
            mTaurusXRewardedAds = new TaurusXRewardedAds(this);
            mTaurusXRewardedAds.setAdUnitId(Constants.REWARDID);
            mTaurusXRewardedAds.loadReward();
            mTaurusXRewardedAds.setListener(new OnTaurusXRewardListener() {
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
                    Toast.makeText(getApplicationContext(), "reward ads load error : " + adError,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdShowFailed(TaurusXAdError taurusXAdError) {

                }

                @Override
                public void onVideoStart() {
                }

                @Override
                public void onVideoCompleted() {
                }

                @Override
                public void onRewarded(TaurusXRewardedAds.RewardItem item) {
                }

                @Override
                public void onRewardFailed() {

                }
            });
        });

        showBtn.setOnClickListener(v -> {
            if (mTaurusXRewardedAds != null && mTaurusXRewardedAds.isReady()) {
                mTaurusXRewardedAds.showReward();
                showBtn.setEnabled(false);
            }
        });
    }
}
