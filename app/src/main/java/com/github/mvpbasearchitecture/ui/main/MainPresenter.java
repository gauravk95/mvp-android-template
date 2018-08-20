package com.github.mvpbasearchitecture.ui.main;

import com.github.mvpbasearchitecture.base.BasePresenter;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter(AppRepository appRepository,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(appRepository, schedulerProvider, compositeDisposable);
    }

}
