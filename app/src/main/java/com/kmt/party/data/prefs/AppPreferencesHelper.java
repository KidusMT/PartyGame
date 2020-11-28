package com.kmt.party.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kmt.party.data.model.Player;
import com.kmt.party.di.ApplicationContext;
import com.kmt.party.di.PreferenceInfo;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {
    public static final String PREF_KEY_CURRENT_LANGUAGE = "PREF_KEY_CURRENT_LANGUAGE";
    public static final String PREF_KEY_PLAYERS = "PREF_KEY_PLAYERS";
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getCurrentLanguage() {
        return mPrefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en");
    }

    @Override
    public void setCurrentLanguage(String language) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_LANGUAGE, language).apply();
    }

    @Override
    public void setPlayerList(List<Player> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        set(json);
    }

    public void set(String value) {
        mPrefs.edit().putString(PREF_KEY_PLAYERS, value).apply();
    }

    @Override
    public List<Player> getPlayerList() {
        List<Player> arrayItems = null;
        String serializedObject = mPrefs.getString(PREF_KEY_PLAYERS, null);
        if (serializedObject != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Player>>(){}.getType();
            arrayItems = gson.fromJson(serializedObject, type);
        }
        return arrayItems;
    }
}
