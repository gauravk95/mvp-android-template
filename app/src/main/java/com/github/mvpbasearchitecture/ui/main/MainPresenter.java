package com.github.mvpbasearchitecture.ui.main;

import com.github.mvpbasearchitecture.base.BasePresenter;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    @Inject
    public MainPresenter(MainContract.View view,
                         AppDataSource appSource,
                         Scheduler execThread,
                         Scheduler postExecThread,
                         CompositeDisposable compositeDisposable) {
        super(view, appSource, execThread, postExecThread, compositeDisposable);

        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        //Do Something
    }

    @Override
    public void unSubscribe() {
        super.subscribe();
    }

}
