package com.kmt.party.ui.never;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.kmt.party.R;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.settings.SettingsActivity;
import com.kmt.party.utils.ScreenUtils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NeverActivity extends BaseActivity implements NeverMvpView {

    @Inject
    NeverMvpPresenter<NeverMvpView> mPresenter;

    //    @BindView(R.id.lwv)
//    LuckyWheel luckyWheel;
    @BindView(R.id.cards_container)
    SwipePlaceHolderView mCardsContainerView;
    @BindView(R.id.btn_dirty_selected)
    ImageView btnSelectedDirty;
    @BindView(R.id.btn_fun_selected)
    ImageView btnSelectedFun;
    @BindView(R.id.btn_party_selected)
    ImageView btnSelectedParty;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, NeverActivity.class);
    }

    @OnClick(R.id.btn_instruction)
    void onInstructionClicked() {
        // open settings screen
        // 1) change language
        // 2) instruction of the game
        startActivity(SettingsActivity.getStartIntent(NeverActivity.this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @OnClick(R.id.btn_party)
    void onPartyClick() {
        hideSelectionBtns();
        btnSelectedParty.setVisibility(View.VISIBLE);
        mPresenter.onPartyClicked();
    }

    @OnClick(R.id.btn_dirty)
    void onDirtyClick() {
        hideSelectionBtns();
        btnSelectedDirty.setVisibility(View.VISIBLE);
        mPresenter.onDirtyClicked();
    }

    @OnClick(R.id.btn_fun)
    void onFunClick() {
        hideSelectionBtns();
        mPresenter.onFunnyClicked();
        btnSelectedFun.setVisibility(View.VISIBLE);
    }

    private void hideSelectionBtns() {
        btnSelectedDirty.setVisibility(View.GONE);
        btnSelectedFun.setVisibility(View.GONE);
        btnSelectedParty.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_back)
    public void OnClickBack(View view) {
        onBackPressed();
        finish();
    }

    @Override
    protected void setUp() {
        setupCardContainerView();
        mPresenter.onCardExhausted();
        hideSelectionBtns();
    }

    @Override
    public void refreshQuestionnaire(List<Question> questionList) {
        for (Question question : questionList) {
            if (question != null) {
                Collections.shuffle(questionList);
                mCardsContainerView.addView(new NeverQuestionCard(question));
            }
        }
    }

    private void setupCardContainerView() {

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight(this);

        mCardsContainerView.getBuilder()
                .setDisplayViewCount(1)
                .setHeightSwipeDistFactor(10)
                .setWidthSwipeDistFactor(5)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth((int) (0.90 * screenWidth))
                        .setViewHeight((int) (0.85 * screenHeight))
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f));

        mCardsContainerView.addItemRemoveListener(count -> {
            if (count == 0) {
                // reload the contents again after 1 sec delay
                new Handler(getMainLooper()).postDelayed(() ->
                        mPresenter.onCardExhausted(), 400);
            }
        });
    }

    @Override
    public void reloadQuestionnaire(List<Question> questionList) {
        mCardsContainerView.removeAllViews();
        refreshQuestionnaire(questionList);
        Collections.shuffle(questionList);
        ScaleAnimation animation = new ScaleAnimation(
                1.15f, 1, 1.15f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mCardsContainerView.setAnimation(animation);
        animation.setDuration(100);
        animation.start();
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
