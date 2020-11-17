package com.kmt.party.ui.settings;

import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;

@PerActivity
public interface SettingsMvpPresenter<V extends SettingsMvpView> extends MvpPresenter<V> {

    void resolveCurrentLanguage();
}
