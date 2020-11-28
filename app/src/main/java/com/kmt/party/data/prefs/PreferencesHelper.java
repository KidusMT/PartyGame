package com.kmt.party.data.prefs;

import com.kmt.party.data.model.Player;

import java.util.List;

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface PreferencesHelper {

    String getCurrentLanguage();

    void setCurrentLanguage(String language);

    void setPlayerList(List<Player> list);

    List<Player> getPlayerList();
}
