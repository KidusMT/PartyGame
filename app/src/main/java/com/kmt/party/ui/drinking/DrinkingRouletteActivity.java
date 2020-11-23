package com.kmt.party.ui.drinking;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kmt.luckwheel.LuckyWheel;
import com.kmt.luckwheel.WheelItem;
import com.kmt.party.R;
import com.kmt.party.data.model.Player;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.drinking.dialog.DrinkingQuestionsDialog;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.settings.SettingsActivity;
import com.kmt.party.ui.team.TeamActivity;
import com.kmt.party.ui.team.dialog.AddPlayerDialog;
import com.kmt.party.utils.RouletteColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrinkingRouletteActivity extends BaseActivity implements DrinkingRouletteMvpView {
    public static final String TAG = DrinkingRouletteActivity.class.getSimpleName();
    public static ArrayList<Player> players = new ArrayList<>();
    ArrayList<Question> questionArrayList = new ArrayList<>();
    @Inject
    DrinkingRouletteMvpPresenter<DrinkingRouletteMvpView> mPresenter;
    @BindView(R.id.lwv)
    LuckyWheel luckyWheel;

    public static Intent getStartIntent(Context context, ArrayList<Player> list) {
        players = list;
        return new Intent(context, DrinkingRouletteActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking_roulette);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    public void onBackPressed() {
        startActivity(TeamActivity.getStartIntent(DrinkingRouletteActivity.this));
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @OnClick(R.id.btn_instruction)
    void onInstructionClicked() {
        // open settings screen
        // 1) change language
        // 2) instruction of the game
        startActivity(SettingsActivity.getStartIntent(DrinkingRouletteActivity.this, TAG));
    }

    @OnClick(R.id.btn_back)
    public void OnClickBack(View view) {
        onBackPressed();
    }

    @Override
    protected void setUp() {
        final int[] currentQuestion = {0};
        mPresenter.setQuestions(DrinkingRouletteActivity.this);
        List<WheelItem> wheelItems = new ArrayList<>(players.size());
        int[] colors = {RouletteColor.ONE, RouletteColor.TWO, RouletteColor.THREE};
        Collections.shuffle(players);
        for (int i = 0; i < players.size(); i++) {
            wheelItems.add(new WheelItem(colors[i % 3], players.get(i).getName()));
        }
        int[] randNum = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            randNum[i] = i + 1;
        }
        Collections.shuffle(questionArrayList);
        Question selectedQuestion = questionArrayList.get(0);//by default 1st item
        for (int i = 0; i < questionArrayList.size(); i++) {
            selectedQuestion = questionArrayList.get(i);
        }

        if (players.size()>0){
            luckyWheel.addWheelItems(wheelItems);
            Random rand = new Random();
            final int[] targ = {randNum[rand.nextInt(1000) % (players.size() - 1)]};
            luckyWheel.setTarget(targ[0]);
            luckyWheel.setLuckyWheelReachTheTarget(() -> {
                DrinkingQuestionsDialog.newInstance(questionArrayList.get(currentQuestion[0]), players.get(targ[0] - 1)).show(getSupportFragmentManager(), AddPlayerDialog.TAG);
                targ[0] = randNum[rand.nextInt(1000) % (players.size() - 1)];
                luckyWheel.setTarget(targ[0]);
                currentQuestion[0]++;
                if (currentQuestion[0] >= questionArrayList.size())
                    currentQuestion[0] = 0;// resetting when reached on last item
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void populateCard(ArrayList<Question> questions) {
        questionArrayList = questions;
    }
}
