package com.kmt.party.ui.drinking.dialog;

import com.kmt.party.ui.base.MvpPresenter;

public interface DrinkingQuestionsMvpPresenter<V extends DrinkingQuestionsMvpView> extends MvpPresenter<V> {

    void onCancelClick();

}
