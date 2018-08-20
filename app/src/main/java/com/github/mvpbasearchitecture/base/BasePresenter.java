package com.github.mvpbasearchitecture.base;

import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V>{

    private AppDataSource mAppDataRepository;
    private Scheduler mExecutionThread, mPostExecutionThread;
    private CompositeDisposable mCompositeDisposable;

    private V mView;

    @Inject
    public BasePresenter(AppDataSource appSource,
                         Scheduler execThread,
                         Scheduler postExecThread,
                         CompositeDisposable compositeDisposable) {
        this.mAppDataRepository = appSource;
        this.mExecutionThread = execThread;
        this.mPostExecutionThread = postExecThread;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void subscribe(V view) {
        this.mView = view;
    }

    @Override
    public void unSubscribe() {
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

    protected Scheduler getExecutionThread(){
        return mExecutionThread;
    }

    protected Scheduler getmPostExecutionThread(){
        return mPostExecutionThread;
    }

}
