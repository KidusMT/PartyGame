package com.kmt.party.ui.settings.instruction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.settings.SettingsActivity;
import com.kmt.party.ui.team.TeamActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameRuleActivity extends BaseActivity implements GameRuleMvpView {
    public static final String TAG = GameRuleActivity.class.getSimpleName();
    public static String fromScreen = NeverActivity.TAG;
    @Inject
    GameRuleMvpPresenter<GameRuleMvpView> mPresenter;

    @BindView(R.id.instruction_toolbar_title)
    TextView tvToolbarTitle;

    @BindView(R.id.drinking_roulette_instruction)
    CardView drinkingRouletteContainer;

    @BindView(R.id.never_have_i_instruction)
    CardView neverHaveIContainer;

    @BindView(R.id.never_description)
    TextView neverDescription;

    @BindView(R.id.never_game_rules)
    TextView neverRules;

    @BindView(R.id.drinking_game_description)
    TextView drinkingDescription;

    @BindView(R.id.drinking_game_rules)
    TextView drinkingRules;

    public static Intent getStartIntent(Context context, String from) {
        fromScreen = from;
        return new Intent(context, GameRuleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rule);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        // the presenter
        mPresenter.onAttach(GameRuleActivity.this);

        setUp();

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        if (fromScreen.equals(DrinkingRouletteActivity.TAG)) {
            drinkingRouletteContainer.setVisibility(View.VISIBLE);
            neverHaveIContainer.setVisibility(View.GONE);
            tvToolbarTitle.setText(getString(R.string.drinking_roulette));
            drinkingDescription.setText(Html.fromHtml(getString(R.string.drinking_description)));
            drinkingRules.setText(Html.fromHtml(getString(R.string.drinking_rules)));
        } else {
            neverHaveIContainer.setVisibility(View.VISIBLE);
            drinkingRouletteContainer.setVisibility(View.GONE);
            tvToolbarTitle.setText(getString(R.string.never_have_i_ever_menu));
            neverDescription.setText(Html.fromHtml(getString(R.string.never_have_i_ever_description)));
            neverRules.setText(Html.fromHtml(getString(R.string.never_have_i_ever_game_rules)));
        }
    }

    @OnClick(R.id.back_button)
    public void OnClickBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(SettingsActivity.getStartIntent(GameRuleActivity.this, fromScreen));
        finish();
    }
}
