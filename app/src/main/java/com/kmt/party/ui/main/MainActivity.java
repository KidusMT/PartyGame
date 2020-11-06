package com.kmt.party.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.kmt.party.MvpApp;
import com.kmt.party.R;
import com.kmt.party.data.model.MusicData;
import com.kmt.party.data.model.VibPattern;
import com.kmt.party.ui.base.BaseActivity;
import com.kmt.party.ui.main.musicDialog.MusicListDialog;
import com.kmt.party.utils.GridSpacingItemDecoration;
import com.kmt.party.utils.MusicPlayerUtils;
import com.skyfishjy.library.RippleBackground;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.kmt.party.utils.ViewUtils.dpToPx;

public class MainActivity extends BaseActivity implements MainMvpView, MenuAdapter.Callback, DialogCommunicator {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    MenuAdapter mAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.layout_content)
    View layout_content;

    @BindView(R.id.appbarLayout)
    AppBarLayout appBarLayout;

    @BindView(R.id.start)
    ImageView ivStart;

    @BindView(R.id.rv_application)
    RecyclerView mRecyclerView;
    Vibrator vibrator;
    List<VibPattern> patterns = new ArrayList<>();
    List<MusicData> musicList = new ArrayList<>();
    private boolean isVibrating = false;
    private String selectedMusic = "";
    private long[] selectPattern;
    private boolean isMusicOn = true;
    private boolean isNightMode;
    private MenuItem nightMode;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MvpApp.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mAdapter.setCallback(this);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            isNightMode = true;

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
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        setupMenuRecyclerView();
        if (patterns.size() > 0)
            selectPattern = patterns.get(0).pattern;

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final RippleBackground rippleBackground = findViewById(R.id.content);
        ivStart.setOnClickListener(view -> {
            if (selectPattern != null) {
                isVibrating = !isVibrating;
                if (isVibrating) {
                    startMusic(selectedMusic);
                    rippleBackground.startRippleAnimation();
                    ivStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));
                    startVibration(selectPattern);
                } else {
                    stopMusic();
                    rippleBackground.stopRippleAnimation();
                    ivStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_start));
                    stopVibration();
                }
            }
        });
    }

    private void startMusic(String selectedMusic) {
        if (!TextUtils.isEmpty(selectedMusic) && isMusicOn && isVibrating) {
            stopMusic();
            MusicPlayerUtils.playSound(MainActivity.this, selectedMusic);
        }
    }

    private void stopMusic() {
        if (isMusicOn)
            MusicPlayerUtils.stopSound();
    }

    private void startVibration(long[] selectPattern) {
        if (isVibrating)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createWaveform(selectPattern, 0));
            } else {
                //deprecated in API 26
                vibrator.vibrate(selectPattern, 0); // repeats forever
            }
    }

    private void stopVibration() {
        vibrator.cancel();
    }

    private void setupMenuRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onItemClicked(VibPattern application) {
        selectPattern = application.pattern;
        startVibration(selectPattern);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        nightMode = menu.findItem(R.id.menu_mode);
        if (isNightMode) nightMode.setIcon(R.drawable.ic_light_theme);
        else nightMode.setIcon(R.drawable.ic_night_theme);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        if (item.getItemId() == R.id.menu_mode) {
            isNightMode = !isNightMode;
            if (isNightMode) {
                MvpApp.getInstance().setIsNightModeEnabled(true);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            } else {
                MvpApp.getInstance().setIsNightModeEnabled(false);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        }

        if (item.getItemId() == R.id.menu_music) {
            MusicListDialog.newInstance(musicList, isMusicOn).show(getSupportFragmentManager(), MusicListDialog.TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void setSelectedMusic(String selectedMusic) {
        this.selectedMusic = selectedMusic;
        startMusic(selectedMusic);
    }

    @Override
    public void setMusicOnOff(boolean isPlaying) {
        isMusicOn = isPlaying;
        if (!isMusicOn) MusicPlayerUtils.stopSound();
        else startMusic(selectedMusic);
    }
}
