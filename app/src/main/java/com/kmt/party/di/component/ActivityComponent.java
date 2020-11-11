package com.kmt.party.di.component;

import com.kmt.party.di.PerActivity;
import com.kmt.party.di.module.ActivityModule;
import com.kmt.party.ui.main.MainActivity;
import com.kmt.party.ui.splash.SplashActivity;

import dagger.Component;

@SuppressWarnings({"unused", "RedundantSuppression"})
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);
}
