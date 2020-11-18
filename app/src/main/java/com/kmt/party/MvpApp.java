package com.kmt.party;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.kmt.party.data.DataManager;
import com.kmt.party.di.component.ApplicationComponent;
import com.kmt.party.di.component.DaggerApplicationComponent;
import com.kmt.party.di.module.ApplicationModule;
import com.kmt.party.utils.AppConstants;
import com.kmt.party.utils.AppLogger;
import com.kmt.party.utils.LocaleManager;

import java.util.Locale;

import javax.inject.Inject;

import static com.kmt.party.data.prefs.AppPreferencesHelper.PREF_KEY_CURRENT_LANGUAGE;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class MvpApp extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context mContext;
    @Inject
    DataManager mDataManager;
    private ApplicationComponent mApplicationComponent;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    private static MvpApp singleton = null;

    public static MvpApp getInstance() {

        if(singleton == null)
        {
            singleton = new MvpApp();
        }
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        MultiDex.install(mContext);
        singleton = this;

        setupLanguagePreferences();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }

    private void setupLanguagePreferences() {

        String default_language = getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)
                .getString(PREF_KEY_CURRENT_LANGUAGE, getString(R.string.lang_english_abbr));

        Log.e("Language:P", default_language + "");

        Locale locale = new Locale(default_language);
        Locale.setDefault(locale);
        Configuration config = new Configuration(getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
