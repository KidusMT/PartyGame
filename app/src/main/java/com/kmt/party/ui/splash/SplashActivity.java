package com.kmt.party.ui.splash;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

import com.kmt.party.MvpApp;
import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.textView41)
    TextView tvWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MvpApp.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    protected void setUp() {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        tvWelcome.postDelayed(() -> {
            startActivity(MainActivity.getStartIntent(this));
            finish();
        }, 1000);
    }
}
