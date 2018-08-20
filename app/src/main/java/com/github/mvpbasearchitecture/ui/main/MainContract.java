package com.github.mvpbasearchitecture.ui.main;

import com.github.mvpbasearchitecture.base.BaseContract;

public interface MainContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
