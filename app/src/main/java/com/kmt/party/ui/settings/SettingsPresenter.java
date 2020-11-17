package com.kmt.party.ui.settings;


import com.kmt.party.data.DataManager;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SettingsPresenter<V extends SettingsMvpView> extends BasePresenter<V>
        implements SettingsMvpPresenter<V> {

    private static final String TAG = SettingsPresenter.class.getSimpleName();

    @Inject
    public SettingsPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void resolveCurrentLanguage() {
        getMvpView().setCurrentLanguage(getDataManager().getCurrentLanguage());
    }
}
