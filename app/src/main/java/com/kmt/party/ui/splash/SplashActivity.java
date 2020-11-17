package com.kmt.party.ui.splash;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.menu.MenuActivity;
import com.kmt.party.ui.settings.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {
    public static final String TAG = SplashActivity.class.getSimpleName();

    @BindView(R.id.textView41)
    TextView tvWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            startActivity(MenuActivity.getStartIntent(this));
            finish();
        }, 1000);
    }
}
