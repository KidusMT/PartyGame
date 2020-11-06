package com.kmt.party.di.component;

import com.kmt.party.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;


@SuppressWarnings({"unused", "RedundantSuppression"})
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}
