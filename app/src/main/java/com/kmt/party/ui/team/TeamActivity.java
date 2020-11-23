package com.kmt.party.ui.team;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kmt.party.R;
import com.kmt.party.data.model.Player;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.menu.MenuActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.team.dialog.AddPlayerDialog;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamActivity extends BaseActivity implements TeamMvpView, TeamCommunicator, TeamAdapter.TeamCallback {
    public static final String TAG = TeamActivity.class.getSimpleName();
    @Inject
    TeamMvpPresenter<TeamMvpView> mPresenter;
    @BindView(R.id.player_recycler)
    RecyclerView mRecyclerView;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    TeamAdapter mAdapter;
    @BindView(R.id.tv_no_player)
    TextView mNoAssignedTask;
    public static ArrayList<Player> playerArrayList = new ArrayList<>();
    public static Intent getStartIntent(Context context) {
        return new Intent(context, TeamActivity.class);
    }

    public static Intent getStartIntent(Context context, ArrayList<Player> list) {
        playerArrayList = list;
        return new Intent(context, TeamActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        mAdapter.setTeamCallback(this);

        setUp();
    }

    @Override
    public void onBackPressed() {
        startActivity(MenuActivity.getStartIntent(TeamActivity.this));
        finish();
    }

    @OnClick(R.id.btn_back)
    public void OnClickBack(View view) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        setupTasksRecyclerView();
        showPlayers(playerArrayList);
    }

    public void showPlayers(ArrayList<Player> players){
        if (players!=null & players.size()>0){
            mRecyclerView.setVisibility(View.VISIBLE);
            mNoAssignedTask.setVisibility(View.GONE);
            mAdapter.addItems(players);
        }else{
            mNoAssignedTask.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
    }

    private void setupTasksRecyclerView() {
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.btn_add_players)
    void onAddPlayerClicked() {
        // open dialog
        AddPlayerDialog.newInstance().show(getSupportFragmentManager(),AddPlayerDialog.TAG);
    }

    @OnClick(R.id.btn_play)
    void onPlayClicked(){
        if (playerArrayList.size()>0){
            if (playerArrayList.size()==1){
                showMessage(R.string.add_more_team);
            }else{
                // can play
                startActivity(DrinkingRouletteActivity.getStartIntent(TeamActivity.this, playerArrayList));
                finish();
            }
        }else{
            showMessage(R.string.add_team);
        }
    }

    @Override
    public void onAddClick(Player player) {
        mAdapter.addItem(player);
        playerArrayList.add(player);
        showPlayers(playerArrayList);
    }

    @Override
    public void onItemClearClicked(Player crew) {
        mAdapter.removeItem(crew);
        playerArrayList.remove(crew);
        showPlayers(playerArrayList);
    }
}
