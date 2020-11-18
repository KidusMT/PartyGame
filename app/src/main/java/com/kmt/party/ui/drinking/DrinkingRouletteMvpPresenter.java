package com.kmt.party.ui.drinking;

import android.content.Context;

import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
@PerActivity
public interface DrinkingRouletteMvpPresenter<V extends DrinkingRouletteMvpView> extends MvpPresenter<V> {
    void setQuestions(Context context);
}
