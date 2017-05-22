package com.bajicdusko.presenter;

import android.os.Bundle;

import com.bajicdusko.androidstarterkit.repository.CacheRepository;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class HomePresenter implements FragmentPresenter {

    private final CacheRepository cacheRepository;
    private View view;

    public HomePresenter(CacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    public void init() {
        if (!cacheRepository.isLoggedIn()) {
            view.showLogin();
        } else {
            view.showHome();
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void restore() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

    }

    public interface View extends FragmentPresenter.View {

        void showLogin();

        void showHome();
    }
}

