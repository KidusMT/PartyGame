package com.kmt.party.ui.main;

import androidx.core.util.Consumer;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onViewInitialized() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("been upset with a partner for not performing well."));
        questions.add(new Question("gotten dehydrated during a session."));
        questions.add(new Question("named a location after a session."));
        questions.add(new Question("sucked toes."));
        questions.add(new Question("done it with a family member in the same room (dirty!)."));
        questions.add(new Question("done it With a family member in the same building."));

        getMvpView().refreshQuestionnaire(questions);
    }

    @Override
    public void onCardExhausted() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("been upset with a partner for not performing well."));
        questions.add(new Question("gotten dehydrated during a session."));
        questions.add(new Question("named a location after a session."));
        questions.add(new Question("sucked toes."));
        questions.add(new Question("done it with a family member in the same room (dirty!)."));
        questions.add(new Question("done it With a family member in the same building."));

        getMvpView().reloadQuestionnaire(questions);
    }
}
