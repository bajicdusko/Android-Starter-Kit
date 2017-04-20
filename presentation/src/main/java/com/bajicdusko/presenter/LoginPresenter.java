package com.bajicdusko.presenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public interface LoginPresenter extends FragmentPresenter {

    void setView(View view);

    void onLogin(String s, String toString);

    interface View extends FragmentPresenter.View {

        void onSuccessfulLogin();
    }
}
