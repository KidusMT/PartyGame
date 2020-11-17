package com.kmt.party.ui.drinking;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kmt.luckwheel.LuckyWheel;
import com.kmt.luckwheel.WheelItem;
import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.utils.RouletteColor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinkingRouletteActivity extends BaseActivity implements DrinkingRouletteMvpView {

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
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
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
