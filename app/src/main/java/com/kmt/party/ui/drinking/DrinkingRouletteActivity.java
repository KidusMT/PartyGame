package com.kmt.party.ui.drinking;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kmt.luckwheel.LuckyWheel;
import com.kmt.luckwheel.WheelItem;
import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.menu.MenuActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.settings.SettingsActivity;
import com.kmt.party.utils.RouletteColor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrinkingRouletteActivity extends BaseActivity implements DrinkingRouletteMvpView {
    public static final String TAG = DrinkingRouletteActivity.class.getSimpleName();

    @Inject
    DrinkingRouletteMvpPresenter<DrinkingRouletteMvpView> mPresenter;

    @BindView(R.id.lwv)
    LuckyWheel luckyWheel;

    public static Intent getStartIntent(Context context) {
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
        startActivity(new Intent(DrinkingRouletteActivity.this, MenuActivity.class));
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
        startActivity(SettingsActivity.getStartIntent(DrinkingRouletteActivity.this, NeverActivity.TAG));
    }

    @OnClick(R.id.btn_back)
    public void OnClickBack(View view) {
        onBackPressed();
        finish();
    }

    @Override
    protected void setUp() {
        List<WheelItem> wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(RouletteColor.ONE, "Bezos"));
        wheelItems.add(new WheelItem(RouletteColor.TWO, "Gates"));
        wheelItems.add(new WheelItem(RouletteColor.ONE, "Arnault"));
        wheelItems.add(new WheelItem(RouletteColor.TWO, "Buffett"));
        wheelItems.add(new WheelItem(RouletteColor.ONE, "Ellison"));
        wheelItems.add(new WheelItem(RouletteColor.TWO, "Ortega"));

        luckyWheel.addWheelItems(wheelItems);
        luckyWheel.setTarget(3);
        luckyWheel.setLuckyWheelReachTheTarget(() -> {

        });
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
}
