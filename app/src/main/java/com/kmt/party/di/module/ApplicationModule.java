package com.kmt.party.di.module;

import android.app.Application;
import android.content.Context;

import com.kmt.party.data.AppDataManager;
import com.kmt.party.data.DataManager;
import com.kmt.party.data.prefs.AppPreferencesHelper;
import com.kmt.party.data.prefs.PreferencesHelper;
import com.kmt.party.di.ApiInfo;
import com.kmt.party.di.ApplicationContext;
import com.kmt.party.di.PreferenceInfo;
import com.kmt.party.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @ApiInfo
    String provideApiKey() {
        return null;//BuildConfig.API_KEY;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}