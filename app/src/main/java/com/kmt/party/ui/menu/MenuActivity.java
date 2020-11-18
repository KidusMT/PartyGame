package com.kmt.party.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.team.TeamActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity implements MenuMvpView {
    public static final String TAG = MenuActivity.class.getSimpleName();
    @Inject
    MenuMvpPresenter<MenuMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MenuActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

    }

    @OnClick(R.id.btn_never_have_i_ever)
    void onNeverHaveIEverClick() {
        startActivity(NeverActivity.getStartIntent(this));
        finish();
    }

    @OnClick(R.id.btn_drinking_roulette)
    void onDirtyRouletteClick() {
        startActivity(TeamActivity.getStartIntent(this));
        finish();
    }
}
