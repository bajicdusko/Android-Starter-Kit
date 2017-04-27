package com.bajicdusko.presenter.impl;

import com.bajicdusko.androidstarterkit.repository.CacheRepository;
import com.bajicdusko.presenter.HomePresenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class HomePresenterImpl implements HomePresenter {

    private final CacheRepository cacheRepository;
    private View view;

    public HomePresenterImpl(CacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    @Override
    public void init() {
        if (!cacheRepository.isLoggedIn()) {
            view.showLogin();
        } else {
            view.showHome();
        }
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {

    }
}
