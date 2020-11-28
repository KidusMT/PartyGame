package com.kmt.party.data;

import android.content.Context;

import com.kmt.party.data.model.Player;
import com.kmt.party.data.prefs.PreferencesHelper;
import com.kmt.party.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings({"unused", "RedundantSuppression", "FieldCanBeLocal"})
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = AppDataManager.class.getSimpleName();

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public String getCurrentLanguage() {
        return mPreferencesHelper.getCurrentLanguage();
    }

    @Override
    public void setCurrentLanguage(String language) {
        mPreferencesHelper.setCurrentLanguage(language);
    }

    @Override
    public void setPlayerList(List<Player> list) {
        mPreferencesHelper.setPlayerList(list);
    }

    @Override
    public List<Player> getPlayerList() {
        return mPreferencesHelper.getPlayerList();
    }
}
