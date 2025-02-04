package com.kmt.party.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kmt.party.di.ActivityContext;
import com.kmt.party.di.PerActivity;
import com.kmt.party.ui.base.MvpPresenter;
import com.kmt.party.ui.drinking.DrinkingRouletteMvpPresenter;
import com.kmt.party.ui.drinking.DrinkingRouletteMvpView;
import com.kmt.party.ui.drinking.DrinkingRoulettePresenter;
import com.kmt.party.ui.drinking.dialog.DrinkingQuestionsMvpPresenter;
import com.kmt.party.ui.drinking.dialog.DrinkingQuestionsMvpView;
import com.kmt.party.ui.drinking.dialog.DrinkingQuestionsPresenter;
import com.kmt.party.ui.never.NeverMvpPresenter;
import com.kmt.party.ui.never.NeverMvpView;
import com.kmt.party.ui.never.NeverPresenter;
import com.kmt.party.ui.menu.MenuMvpPresenter;
import com.kmt.party.ui.menu.MenuMvpView;
import com.kmt.party.ui.menu.MenuPresenter;
import com.kmt.party.ui.settings.SettingsMvpPresenter;
import com.kmt.party.ui.settings.SettingsMvpView;
import com.kmt.party.ui.settings.SettingsPresenter;
import com.kmt.party.ui.settings.instruction.GameRuleMvpPresenter;
import com.kmt.party.ui.settings.instruction.GameRuleMvpView;
import com.kmt.party.ui.settings.instruction.GameRulePresenter;
import com.kmt.party.ui.team.TeamAdapter;
import com.kmt.party.ui.team.TeamMvpPresenter;
import com.kmt.party.ui.team.TeamMvpView;
import com.kmt.party.ui.team.TeamPresenter;
import com.kmt.party.ui.team.dialog.AddPlayerMvpPresenter;
import com.kmt.party.ui.team.dialog.AddPlayerMvpView;
import com.kmt.party.ui.team.dialog.AddPlayerPresenter;
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
    NeverMvpPresenter<NeverMvpView> provideMainPresenter(
            NeverPresenter<NeverMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MenuMvpPresenter<MenuMvpView> provideMenuPresenter(
            MenuPresenter<MenuMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DrinkingRouletteMvpPresenter<DrinkingRouletteMvpView> provideDrinkingRoulettePresenter(
            DrinkingRoulettePresenter<DrinkingRouletteMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SettingsMvpPresenter<SettingsMvpView> provideSettingsPresenter(
            SettingsPresenter<SettingsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    GameRuleMvpPresenter<GameRuleMvpView> provideGameRulePresenter(
            GameRulePresenter<GameRuleMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TeamMvpPresenter<TeamMvpView> provideTeamPresenter(
            TeamPresenter<TeamMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AddPlayerMvpPresenter<AddPlayerMvpView> provideAddPlayerPresenter(
            AddPlayerPresenter<AddPlayerMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DrinkingQuestionsMvpPresenter<DrinkingQuestionsMvpView> provideDrinkingQuestionsPresenter(
            DrinkingQuestionsPresenter<DrinkingQuestionsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TeamAdapter provideTeamAdapter() {
        return new TeamAdapter(provideContext(), new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
