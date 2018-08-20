package com.github.mvpbasearchitecture.base;

import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V> implements BaseContract.Presenter<V>{

    private final AppRepository mAppDataRepository;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    private V mView;

    @Inject
    public BasePresenter(AppRepository appRepository,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mAppDataRepository = appRepository;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V view) {
        this.mView = view;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.clear();
        mView = null;
    }

    protected boolean isViewAttached() {
        return mView != null;
    }

    protected V getView(){
        return mView;
    }

    protected AppDataSource getDataSource(){
        return mAppDataRepository;
    }

    protected SchedulerProvider getmSchedulerProvider(){
        return mSchedulerProvider;
    }

}
