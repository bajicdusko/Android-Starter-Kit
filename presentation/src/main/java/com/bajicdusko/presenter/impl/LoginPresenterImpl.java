package com.bajicdusko.presenter.impl;

import com.bajicdusko.presenter.LoginPresenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private View view;

    @Override
    public void dispose() {

    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String s, String toString) {
        view.onSuccessfulLogin();
    }
}
