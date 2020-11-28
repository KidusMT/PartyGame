package com.kmt.party.ui.team.dialog;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Player;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void saveTeamPlayers(Player player) {
        List<Player> players = getDataManager().getPlayerList();
        if (players!=null && players.size()>0){
            players.add(player);
            getDataManager().setPlayerList(players);
        }else{
            List<Player> newPlayers = new ArrayList<>();
            newPlayers.add(player);
            getDataManager().setPlayerList(newPlayers);
        }
    }
}
