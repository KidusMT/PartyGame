package com.kmt.party.ui.never;

import android.content.Context;

import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
@PerActivity
public interface NeverMvpPresenter<V extends NeverMvpView> extends MvpPresenter<V> {

    void onViewInitialized(Context context);

    void onCardExhausted(Context context);

    void onFunnyClicked(Context context);

    void onDirtyClicked(Context context);

    void onPartyClicked(Context context);
}
