package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.ui.authentication.LoginFragment;
import com.bajicdusko.androidstarterkit.ui.fragment.FragmentChannel;
import com.bajicdusko.androidstarterkit.ui.fragment.QuestionFragment;
import com.bajicdusko.androidstarterkit.ui.fragment.manager.FragmentManagerHandler;
import com.bajicdusko.androidstarterkit.ui.view.Utils;
import com.bajicdusko.presenter.HomePresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class HomeActivity extends BaseActivity implements HomePresenter.View, FragmentChannel {

    @Inject FragmentManagerHandler fragmentManagerHandler;
    @Inject HomePresenter homePresenter;

    @BindView(R.id.activity_home_fl_container) FrameLayout flContainer;
    @BindView(R.id.activity_home_tl_main) Toolbar tlMain;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        injector().inject(this);
        setSupportActionBar(tlMain);
        fragmentManagerHandler.setFragmentContainerId(flContainer);

        homePresenter.setView(this);
        if (savedInstanceState == null) {
            homePresenter.init();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        fragmentManagerHandler.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fragmentManagerHandler.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void showLogin() {
        fadeOutToolbar();
        fragmentManagerHandler.addFragment(LoginFragment.newInstance());
    }

    @Override
    public void fadeOutToolbar() {
        if (tlMain.getAlpha() > 0f) {
            Utils.fadeOut(tlMain);
        }
    }

    private void fadeInToolbar() {
        if (tlMain.getAlpha() < 1f) {
            Utils.fadeIn(tlMain);
        }
    }

    @Override
    public void showHome() {
        fragmentManagerHandler.popUpAll();
        fragmentManagerHandler.replaceFragment(QuestionFragment.newInstance());
        fadeInToolbar();
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void dispose() {
        homePresenter.dispose();
    }

    @Override
    public void restore() {

    }

    @Override
    public void onBackPressed() {
        fragmentManagerHandler.onBackPressed();
    }
}
