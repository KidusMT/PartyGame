package com.kmt.party.di.component;

import com.kmt.party.di.PerActivity;
import com.kmt.party.di.module.ActivityModule;
import com.kmt.party.ui.drinking.DrinkingRouletteActivity;
import com.kmt.party.ui.menu.MenuActivity;
import com.kmt.party.ui.never.NeverActivity;
import com.kmt.party.ui.settings.LanguageListActivity;
import com.kmt.party.ui.settings.SettingsActivity;
import com.kmt.party.ui.splash.SplashActivity;

import dagger.Component;

@SuppressWarnings({"unused", "RedundantSuppression"})
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(NeverActivity activity);

    void inject(SplashActivity activity);

    void inject(MenuActivity activity);

    void inject(DrinkingRouletteActivity activity);

    void inject(SettingsActivity activity);

    void inject(LanguageListActivity activity);
}
