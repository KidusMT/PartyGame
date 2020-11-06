package com.kmt.party.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kmt.party.di.ActivityContext;
import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.main.MainMvpPresenter;
import com.kmt.party.ui.main.MainMvpView;
import com.kmt.party.ui.main.MainPresenter;
import com.kmt.party.ui.main.MenuAdapter;
import com.kmt.party.ui.main.musicDialog.MusicAdapter;
import com.kmt.party.ui.main.musicDialog.MusicListMvpPresenter;
import com.kmt.party.ui.main.musicDialog.MusicListMvpView;
import com.kmt.party.ui.main.musicDialog.MusicListPresenter;
import com.kmt.party.utils.rx.AppSchedulerProvider;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MenuAdapter provideMenuAdapter() {
        return new MenuAdapter(provideContext(), new ArrayList<>());
    }

    @Provides
    @PerActivity
    MusicAdapter provideMusicAdapter() {
        return new MusicAdapter(provideContext(), new ArrayList<>());
    }

    @Provides
    @PerActivity
    MusicListMvpPresenter<MusicListMvpView> provideMusicListPresenter(
            MusicListPresenter<MusicListMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
