package com.kmt.party.ui.main;

import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void onCardExhausted();
}
