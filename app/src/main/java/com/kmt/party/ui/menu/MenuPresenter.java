package com.kmt.party.ui.menu;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MenuPresenter<V extends MenuMvpView> extends BasePresenter<V> implements MenuMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = MenuPresenter.class.getSimpleName();
    private List<Question> questionList = new ArrayList<>();

    @Inject
    public MenuPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
