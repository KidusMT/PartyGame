package com.kmt.party.ui.settings.instruction;


import com.kmt.party.data.DataManager;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GameRulePresenter<V extends GameRuleMvpView> extends BasePresenter<V>
        implements GameRuleMvpPresenter<V> {

    private static final String TAG = GameRulePresenter.class.getSimpleName();

    @Inject
    public GameRulePresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
