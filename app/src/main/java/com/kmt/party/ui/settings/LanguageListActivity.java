package com.kmt.party.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.utils.AppConstants;
import com.kmt.party.utils.AppLogger;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kmt.party.data.prefs.AppPreferencesHelper.PREF_KEY_CURRENT_LANGUAGE;

public class LanguageListActivity extends BaseActivity implements View.OnClickListener {

    RadioButton mRadioButton_russian, mRadioButton_english, mRadioButton_spanish, mRadioButton_portugal,
            mRadioButton_german, mRadioButton_french, mRadioButton_japanese;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_list);


        mRadioButton_english = findViewById(R.id.check_english);
        mRadioButton_russian = findViewById(R.id.check_russian);
        mRadioButton_spanish = findViewById(R.id.check_spanish);
        mRadioButton_portugal = findViewById(R.id.check_portuguese);
        mRadioButton_german = findViewById(R.id.check_german);
        mRadioButton_french = findViewById(R.id.check_french);
        mRadioButton_japanese = findViewById(R.id.check_japanese);

        mRadioButton_english.setOnClickListener(this);
        mRadioButton_russian.setOnClickListener(this);
        mRadioButton_spanish.setOnClickListener(this);
        mRadioButton_portugal.setOnClickListener(this);
        mRadioButton_german.setOnClickListener(this);
        mRadioButton_french.setOnClickListener(this);
        mRadioButton_japanese.setOnClickListener(this);

        findViewById(R.id.check_english_container).setOnClickListener(this);
        findViewById(R.id.check_russian_container).setOnClickListener(this);
        findViewById(R.id.check_spanish_container).setOnClickListener(this);
        findViewById(R.id.check_portuguese_container).setOnClickListener(this);
        findViewById(R.id.check_german_container).setOnClickListener(this);
        findViewById(R.id.check_french_container).setOnClickListener(this);
        findViewById(R.id.check_japanese_container).setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        String currentLanguage = sharedPreferences.getString(PREF_KEY_CURRENT_LANGUAGE, "en");

        ButterKnife.bind(this);
        if (currentLanguage.equals("en")) {
            setLanguageButtonActive("en");
        } else if (currentLanguage.equals("ru")) {
            setLanguageButtonActive("ru");
        } else if (currentLanguage.equals("es")) {
            setLanguageButtonActive("es");
        } else if (currentLanguage.equals("pt")) {
            setLanguageButtonActive("pt");
        } else if (currentLanguage.equals("de")) {
            setLanguageButtonActive("de");
        } else if (currentLanguage.equals("fr")) {
            setLanguageButtonActive("fr");
        } else if (currentLanguage.equals("ja")) {
            setLanguageButtonActive("ja");
        }
    }

    public void setLanguageButtonActive(String lang) {
        mRadioButton_english.setChecked(false);
        mRadioButton_russian.setChecked(false);
        mRadioButton_spanish.setChecked(false);
        mRadioButton_portugal.setChecked(false);
        mRadioButton_german.setChecked(false);
        mRadioButton_french.setChecked(false);
        mRadioButton_japanese.setChecked(false);
        switch (lang) {
            case "en":
                mRadioButton_english.setChecked(true);
                break;
            case "ru":
                mRadioButton_russian.setChecked(true);
                break;
            case "es":
                mRadioButton_spanish.setChecked(true);
                break;
            case "pt":
                mRadioButton_portugal.setChecked(true);
                break;
            case "de":
                mRadioButton_german.setChecked(true);
                break;
            case "fr":
                mRadioButton_french.setChecked(true);
                break;
            case "ja":
                mRadioButton_japanese.setChecked(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.check_english:
            case R.id.check_english_container:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    config.setLocale(locale);
                } else {
                    config.locale = locale;
                }
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString("PREF_KEY_CURRENT_LANGUAGE", "en").apply();
                setLanguageButtonActive("en");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(this, LanguageListActivity.class);
                startActivity(intent);
                onConfigurationChanged(config);
                finish();

                break;
            case R.id.check_russian:
            case R.id.check_russian_container:

                Locale localeRu = new Locale("ru");
                Locale.setDefault(localeRu);
                Configuration configRu = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configRu.setLocale(localeRu);
                } else {
                    configRu.locale = localeRu;
                }
                getResources().updateConfiguration(configRu, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "ru").apply();
                setLanguageButtonActive("ru");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent1 = new Intent(this, LanguageListActivity.class);
                startActivity(intent1);
                onConfigurationChanged(configRu);
                finish();

                break;
            case R.id.check_spanish:
            case R.id.check_spanish_container:

                Locale localeEs = new Locale("es");
                Locale.setDefault(localeEs);
                Configuration configEs = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configEs.setLocale(localeEs);
                } else {
                    configEs.locale = localeEs;
                }
                getResources().updateConfiguration(configEs, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "es").apply();
                setLanguageButtonActive("es");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, LanguageListActivity.class));
                onConfigurationChanged(configEs);
                finish();

                break;
            case R.id.check_portuguese:
            case R.id.check_portuguese_container:

                Locale localePt = new Locale("pt");
                Locale.setDefault(localePt);
                Configuration configPt = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configPt.setLocale(localePt);
                } else {
                    configPt.locale = localePt;
                }
                getResources().updateConfiguration(configPt, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "pt").apply();
                setLanguageButtonActive("pt");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, LanguageListActivity.class));
                onConfigurationChanged(configPt);
                finish();

                break;
            case R.id.check_german:
            case R.id.check_german_container:

                Locale localeDe = new Locale("de");
                Locale.setDefault(localeDe);
                Configuration configDe = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configDe.setLocale(localeDe);
                } else {
                    configDe.locale = localeDe;
                }
                getResources().updateConfiguration(configDe, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "de").apply();
                setLanguageButtonActive("de");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, LanguageListActivity.class));
                onConfigurationChanged(configDe);
                finish();

                break;
            case R.id.check_french:
            case R.id.check_french_container:

                Locale localeFr = new Locale("fr");
                Locale.setDefault(localeFr);
                Configuration configFr = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configFr.setLocale(localeFr);
                } else {
                    configFr.locale = localeFr;
                }
                getResources().updateConfiguration(configFr, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "fr").apply();
                setLanguageButtonActive("fr");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, LanguageListActivity.class));
                onConfigurationChanged(configFr);
                finish();

                break;
            case R.id.check_japanese:
            case R.id.check_japanese_container:

                Locale localeJa = new Locale("ja");
                Locale.setDefault(localeJa);
                Configuration configJa = new Configuration(getResources().getConfiguration());
                if (Build.VERSION.SDK_INT >= 17) {
                    configJa.setLocale(localeJa);
                } else {
                    configJa.locale = localeJa;
                }
                getResources().updateConfiguration(configJa, getResources().getDisplayMetrics());

                sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, "ja").apply();
                setLanguageButtonActive("ja");
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, LanguageListActivity.class));
                onConfigurationChanged(configJa);
                finish();

                break;
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        // refresh your views here
        AppLogger.e("---onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.back_button)
    public void onBackClick(View v) {
        startActivity(new Intent(LanguageListActivity.this, SettingsActivity.class));
        finish();
    }
}
