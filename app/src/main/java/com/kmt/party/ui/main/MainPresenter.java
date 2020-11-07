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

        Random rand = new Random();

        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("been upset with a partner for not performing well.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("gotten dehydrated during a session.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("named a location after a session.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("sucked toes.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("done it with a family member in the same room (dirty!).");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("done it With a family member in the same building.");
        questions.add(question);

        getMvpView().refreshQuestionnaire(questions);
    }

    @Override
    public void onCardExhausted() {
        Random rand = new Random();

        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("been upset with a partner for not performing well.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("gotten dehydrated during a session.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("named a location after a session.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("sucked toes.");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("done it with a family member in the same room (dirty!).");
        questions.add(question);

        question = new Question();
        question.setId(rand.nextLong());
        question.setQuestionText("done it With a family member in the same building.");
        questions.add(question);

        getMvpView().reloadQuestionnaire(questions);
    }
}
