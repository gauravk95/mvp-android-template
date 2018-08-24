package com.github.mvpbasearchitecture.base;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * The base contract
 * Consists of the Presenter and View interface
 * Helps in communication/establish contract between View and Presenter
 *
 * Created by gk
 */

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

        void onError(String message);

        void onError(@StringRes int resId);

    }

    interface Presenter<V> {

        void onAttach(V view);

        void onDetach();

        void handleApiError(Throwable throwable);

    }

}
