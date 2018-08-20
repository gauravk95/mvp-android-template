package com.github.mvpbasearchitecture.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.di.component.DaggerActivityComponent;
import com.github.mvpbasearchitecture.di.module.ActivityModule;
import com.github.mvpbasearchitecture.utils.DialogUtils;
import com.github.mvpbasearchitecture.utils.GeneralUtils;

/**
 * Created by gk
 */

public abstract class BaseMVPActivity<T> extends AppCompatActivity implements BaseContract.View<T>  {

    protected Dialog progressDialog;
    protected ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MainApplication) getApplication()).getComponent())
                .build();

    }

    protected ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onNewIntent(Intent intent) {
        this.setIntent(intent);
    }

    /**
     * Custom Progress Dialog with loading dots animation
     * @param message
     */
    @Override
    public void showProgressDialog(String title, @NonNull String message) {
        progressDialog = DialogUtils.createProgressDialog(BaseMVPActivity.this);
    }

    /**
     * Custom Progress Dialog with loading dots animation
     * @param resId
     */
    @Override
    public void showProgressDialog(@StringRes int resId) {
        String message = getString(resId);
        if(GeneralUtils.checkStringNotEmpty(message))
            showProgressDialog(null,message);
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showToastMessage(@NonNull String message) {
        if (GeneralUtils.checkStringNotEmpty(message))
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastMessage(@StringRes int resId) {
        showToastMessage(getString(resId));
    }

    @Override
    public void showSnackBarMessage(@NonNull String message){
        if(GeneralUtils.checkStringNotEmpty(message))
            showSnackBar(message);
    }

    @Override
    public void showSnackBarMessage(@StringRes int resId){
            showSnackBarMessage(getString(resId));
    }

    /**
     * Creates a SnackBar for message display
     */
    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dismissProgressDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
    }

}
