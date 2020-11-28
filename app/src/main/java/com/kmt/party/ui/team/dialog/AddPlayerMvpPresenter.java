package com.kmt.party.ui.team.dialog;

import com.kmt.party.data.model.Player;
import com.kmt.party.ui.base.MvpPresenter;

public interface AddPlayerMvpPresenter<V extends AddPlayerMvpView> extends MvpPresenter<V> {

    void onCancelClick();
    void saveTeamPlayers(Player player);
}
