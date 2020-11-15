package com.kmt.party.ui.drinking;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DrinkingRoulettePresenter<V extends DrinkingRouletteMvpView> extends BasePresenter<V> implements DrinkingRouletteMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = DrinkingRoulettePresenter.class.getSimpleName();
    private List<Question> questionList = new ArrayList<>();

    @Inject
    public DrinkingRoulettePresenter(DataManager dataManager,
                                     SchedulerProvider schedulerProvider,
                                     CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
