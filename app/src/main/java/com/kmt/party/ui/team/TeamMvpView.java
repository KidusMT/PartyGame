package com.kmt.party.ui.team;

import com.kmt.party.data.model.Player;
import com.kmt.party.ui.base.MvpView;

import java.util.ArrayList;

public interface TeamMvpView extends MvpView {
    void showPlayers(ArrayList<Player> players);
}
