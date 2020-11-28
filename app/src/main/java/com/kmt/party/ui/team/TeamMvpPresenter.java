package com.kmt.party.ui.team;

import com.kmt.party.data.model.Player;
import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

import java.util.ArrayList;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
@PerActivity
public interface TeamMvpPresenter<V extends TeamMvpView> extends MvpPresenter<V> {
    void populatePlayers();
}
