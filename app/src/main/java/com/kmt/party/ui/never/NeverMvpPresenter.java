package com.kmt.party.ui.never;

import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
@PerActivity
public interface NeverMvpPresenter<V extends NeverMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void onCardExhausted();

    void onFunnyClicked();

    void onDirtyClicked();

    void onPartyClicked();
}
