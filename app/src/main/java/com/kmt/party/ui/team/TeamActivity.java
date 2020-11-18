package com.kmt.party.ui.team;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.never.NeverActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamActivity extends BaseActivity implements TeamMvpView {
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
    public static Intent getStartIntent(Context context) {
        return new Intent(context, TeamActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        setupTasksRecyclerView();
    }

    private void setupTasksRecyclerView() {
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.btn_never_have_i_ever)
    void onNeverHaveIEverClick() {
        startActivity(NeverActivity.getStartIntent(this));
    }

    @OnClick(R.id.btn_drinking_roulette)
    void onDirtyRouletteClick() {
        startActivity(DrinkingRouletteActivity.getStartIntent(this));
    }
}
