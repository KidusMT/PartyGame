package com.kmt.party.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.settings.instruction.GameRuleActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity implements SettingsMvpView {
    public static final String TAG = SettingsActivity.class.getSimpleName();
    public static String fromScreen = NeverActivity.TAG;
    @Inject
    SettingsMvpPresenter<SettingsMvpView> mPresenter;
    @BindView(R.id.lbl_current_language)
    TextView mCurrentLanguage;

    public static Intent getStartIntent(Context context, String from) {
        fromScreen = from;
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

    @OnClick(R.id.btn_settings_drinking_instruction)
    void onDrinkingRouletteInstructionClicked(){
        startActivity(GameRuleActivity.getStartIntent(SettingsActivity.this, DrinkingRouletteActivity.TAG));
        finish();
    }

    @OnClick(R.id.btn_settings_never_instruction)
    void onNeverEverHaveInstructionClicked(){
        startActivity(GameRuleActivity.getStartIntent(SettingsActivity.this, NeverActivity.TAG));
        finish();
    }

    @Override
    protected void setUp() {
        mPresenter.resolveCurrentLanguage();
    }

    @Override
    public void setCurrentLanguage(String language) {
        changeLanguage(language);
    }

    public void changeLanguage(String language) {
        if (language.equals(getString(R.string.lang_english_abbr))) {
            mCurrentLanguage.setText(R.string.lang_english);
        } else if (language.equals(getString(R.string.lang_russian_abbr))) {
            mCurrentLanguage.setText(R.string.lang_russian);
        } else if (language.equals(getString(R.string.lang_spanish_abbr))) {
            mCurrentLanguage.setText(R.string.lang_spanish);
        } else if (language.equals(getString(R.string.lang_portuguese_abbr))) {
            mCurrentLanguage.setText(R.string.lang_portuguese);
        } else if (language.equals(getString(R.string.lang_german_abbr))) {
            mCurrentLanguage.setText(R.string.lang_german);
        } else if (language.equals(getString(R.string.lang_french_abbr))) {
            mCurrentLanguage.setText(R.string.lang_french);
        } else if (language.equals(getString(R.string.lang_japanese_abbr))) {
            mCurrentLanguage.setText(R.string.lang_japanese);
        }
    }

    @OnClick(R.id.layout_current_language)
    public void onClickCurrentLanguage(View view) {
        startActivity(LanguageListActivity.getStartIntent(SettingsActivity.this, fromScreen));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.back_button)
    public void OnClickBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (fromScreen.equals(NeverActivity.TAG)) {
            startActivity(new Intent(SettingsActivity.this, NeverActivity.class));
            finish();
        } else {
            startActivity(new Intent(SettingsActivity.this, DrinkingRouletteActivity.class));
            finish();
        }
    }

}
