package com.github.mvpbasearchitecture.base;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

public interface BaseContract {

    interface View<T> {

        void setPresenter(T presenter);

        void showProgressDialog(String title, @NonNull String message);

        void showProgressDialog(@StringRes int resId);

        void dismissProgressDialog();

        void showToastMessage(@NonNull String message);

        void showToastMessage(@StringRes int stringResourceId);

        void showSnackBarMessage(@NonNull String message);

        void showSnackBarMessage(@StringRes int stringResourceId);

    }

    interface Presenter<V> {

        void subscribe(V view);

        void unSubscribe();

    }

}
