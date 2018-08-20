package com.github.mvpbasearchitecture.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by gk.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
