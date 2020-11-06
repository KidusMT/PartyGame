package com.kmt.party.utils.rx;

import io.reactivex.Scheduler;

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
