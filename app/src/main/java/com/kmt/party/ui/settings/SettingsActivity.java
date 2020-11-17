package com.kmt.party.ui.settings;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.never.NeverActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity implements SettingsMvpView {

    @Inject
    SettingsMvpPresenter<SettingsMvpView> mPresenter;

    @BindView(R.id.lbl_current_language)
    TextView mCurrentLanguage;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        // the presenter
        mPresenter.onAttach(SettingsActivity.this);

        setUp();

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPresenter.resolveCurrentLanguage();
    }

    @Override
    public void setCurrentLanguage(String language) {
        if (language.equals(getString(R.string.lang_english_abbr))) {
            mCurrentLanguage.setText(R.string.lang_english);
        } else if (language.equals(getString(R.string.lang_amharic_abbr))) {
            mCurrentLanguage.setText(R.string.lang_amharic);
        }
    }

    @OnClick(R.id.layout_current_language)
    public void onClickCurrentLanguage(View view) {
        startActivity(new Intent(this, LanguageListActivity.class));
    }

    private boolean checkLocationPermissionStatus() {
        return hasPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    private boolean checkStoragePermissionStatus() {
        return hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private boolean checkMicrophonePermissionStatus() {
        return hasPermission(Manifest.permission.RECORD_AUDIO);
    }

    private boolean checkCameraPermissionStatus() {
        return hasPermission(Manifest.permission.CAMERA);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.back_button)
    public void OnClickBack(View view) {
        onBackPressed();
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingsActivity.this, NeverActivity.class));
    }

}
