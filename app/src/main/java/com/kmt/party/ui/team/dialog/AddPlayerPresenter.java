package com.kmt.party.ui.team.dialog;

import com.kmt.party.data.DataManager;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AddPlayerPresenter<V extends AddPlayerMvpView> extends BasePresenter<V>
        implements AddPlayerMvpPresenter<V> {

    public static final String TAG = "GeneratePresenter";

    @Inject
    public AddPlayerPresenter(DataManager dataManager,
                              SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCancelClick() {
        getMvpView().dismissDialog();
    }
}
