package com.bajicdusko.presenter;

import android.os.Bundle;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class LoginPresenter implements FragmentPresenter {
    private View view;

    @Override
    public void dispose() {

    }

    @Override
    public void restore() {

    }

    public void setView(View view) {
        this.view = view;
    }

    public void onLogin(String s, String toString) {
        view.onSuccessfulLogin();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

    }

    public interface View extends FragmentPresenter.View {

        void onSuccessfulLogin();
    }
}
