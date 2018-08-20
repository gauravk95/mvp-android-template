package com.github.mvpbasearchitecture.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.base.BaseMVPFragment;
import com.github.mvpbasearchitecture.di.component.ActivityComponent;

import javax.inject.Inject;

/**
 * Created by gk
 */

public class MainFragment extends BaseMVPFragment<MainContract.Presenter> implements MainContract.View{

    private View inflatedView;

    @Inject
    MainContract.Presenter mPresenter;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    public MainFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(R.layout.fragment_main, container, false);

        initViews();

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        return inflatedView;
    }

    private void initViews() {
        //initialize view here
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
