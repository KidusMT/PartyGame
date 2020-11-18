package com.kmt.party.ui.drinking.dialog;

import com.kmt.party.data.DataManager;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DrinkingQuestionsPresenter<V extends DrinkingQuestionsMvpView> extends BasePresenter<V>
        implements DrinkingQuestionsMvpPresenter<V> {

    public static final String TAG = "GeneratePresenter";

    @Inject
    public DrinkingQuestionsPresenter(DataManager dataManager,
                                      SchedulerProvider schedulerProvider,
                                      CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCancelClick() {
        getMvpView().dismissDialog();
    }
}
