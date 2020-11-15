package com.kmt.party.ui.drinking;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.WheelItem;
import com.kmt.party.R;
import com.kmt.party.ui.base.BaseActivity;

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
        wheelItems.add(new WheelItem(Color.BLUE,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Bezos"));

        wheelItems.add(new WheelItem(Color.CYAN,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Gates"));

        wheelItems.add(new WheelItem(Color.MAGENTA,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Arnault"));

        wheelItems.add(new WheelItem(Color.RED,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Buffett"));

        wheelItems.add(new WheelItem(Color.YELLOW,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Ellison"));

        wheelItems.add(new WheelItem(Color.LTGRAY,
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "Ortega"));

        luckyWheel.addWheelItems(wheelItems);
        luckyWheel.setTarget(3);
        luckyWheel.rotateWheelTo(2);
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
