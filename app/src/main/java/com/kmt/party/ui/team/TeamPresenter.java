package com.kmt.party.ui.team;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Player;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TeamPresenter<V extends TeamMvpView> extends BasePresenter<V> implements TeamMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = TeamPresenter.class.getSimpleName();
    private List<Question> questionList = new ArrayList<>();

    @Inject
    public TeamPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void populatePlayers() {
        List<Player> playerList = getDataManager().getPlayerList();
        if (playerList!=null && playerList.size()>0){
            getMvpView().showPlayers(new ArrayList<>(playerList));
        }else{
            getMvpView().showPlayers(new ArrayList<>());
        }
    }
}
