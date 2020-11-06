package com.kmt.party.di.component;

import com.kmt.party.di.PerService;
import com.kmt.party.di.module.ServiceModule;
import com.kmt.party.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
