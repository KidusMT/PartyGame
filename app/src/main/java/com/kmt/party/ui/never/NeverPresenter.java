package com.kmt.party.ui.never;

import android.content.Context;

import com.kmt.party.MvpApp;
import com.kmt.party.R;
import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NeverPresenter<V extends NeverMvpView> extends BasePresenter<V> implements NeverMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = NeverPresenter.class.getSimpleName();
    private List<Question> questionList = new ArrayList<>();
    @Inject
    public NeverPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onAttach(V mvpView) {
        questionList.clear();
        super.onAttach(mvpView);
    }

    public void setFunny(Context context){
        // funny
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_1)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_2)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_3)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_4)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_5)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_6)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_7)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_8)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_9)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_10)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_11)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_12)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_13)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_14)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_15)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_16)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_17)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_18)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_19)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_20)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_21)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_22)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_23)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_24)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_25)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_26)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_27)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_28)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_29)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_30)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_31)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_32)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_33)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_34)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_35)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_36)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_37)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_38)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_39)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_40)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_41)));
        questions.add(new Question(context.getString(R.string.funny_neve_have_i_ever_42)));

        questionList = questions;
    }

    public void setDirty(Context context){
        // Dirty
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_1)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_2)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_3)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_4)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_5)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_6)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_7)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_8)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_9)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_10)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_11)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_12)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_13)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_14)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_15)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_16)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_17)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_18)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_19)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_20)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_21)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_22)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_23)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_24)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_25)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_26)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_27)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_28)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_29)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_30)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_31)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_32)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_33)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_34)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_35)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_36)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_37)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_38)));
        questions.add(new Question(context.getString(R.string.dirty_neve_have_i_ever_39)));

        questionList = questions;
    }

    public void setParty(Context context){
        // Party
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_1)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_2)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_3)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_4)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_5)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_6)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_7)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_8)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_9)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_10)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_11)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_12)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_13)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_14)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_15)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_16)));
        questions.add(new Question(context.getString(R.string.party_neve_have_i_ever_17)));

        questionList = questions;
    }
    @Override
    public void onViewInitialized(Context context) {
        setFunny(context);
        getMvpView().refreshQuestionnaire(questionList);

    }

    @Override
    public void onCardExhausted(Context context) {
        getMvpView().reloadQuestionnaire(questionList);
    }

    @Override
    public void onFunnyClicked(Context context) {
        setFunny(context);
        onCardExhausted(context);
    }

    @Override
    public void onDirtyClicked(Context context) {
        setDirty(context);
        onCardExhausted(context);
    }

    @Override
    public void onPartyClicked(Context context) {
        setParty(context);
        onCardExhausted(context);
    }
}
