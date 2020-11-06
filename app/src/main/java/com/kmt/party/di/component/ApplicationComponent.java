package com.kmt.party.di.component;

import android.app.Application;
import android.content.Context;

import com.kmt.party.MvpApp;
import com.kmt.party.data.DataManager;
import com.kmt.party.di.ApplicationContext;
import com.kmt.party.di.module.ApplicationModule;
import com.kmt.party.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

@SuppressWarnings({"unused", "RedundantSuppression"})
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}