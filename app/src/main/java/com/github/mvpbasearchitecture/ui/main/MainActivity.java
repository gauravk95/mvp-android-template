package com.github.mvpbasearchitecture.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.base.BaseActivity;
import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.utils.ActivityUtils;
import com.github.mvpbasearchitecture.utils.ViewUtils;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (mainFragment == null){
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment,R.id.content_frame);
        }

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getText(R.string.toolbar_title));

        ViewUtils.applyFontForToolbarTitle(this, R.id.toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
