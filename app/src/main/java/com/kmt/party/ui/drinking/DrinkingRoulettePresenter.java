package com.kmt.party.ui.drinking;

import android.content.Context;

import com.kmt.party.R;
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

    @Override
    public void setQuestions(Context context) {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(context.getString(R.string.drink_roulette_q1)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q2)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q3)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q4)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q5)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q6)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q7)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q8)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q9)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q10)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q11)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q12)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q13)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q14)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q15)));
        questions.add(new Question(context.getString(R.string.drink_roulette_q16)));
        getMvpView().populateCard(questions);
    }
}
