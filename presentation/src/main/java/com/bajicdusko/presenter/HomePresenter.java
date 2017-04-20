package com.bajicdusko.presenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface HomePresenter extends Presenter {

    void setView(View view);

    void init();

    interface View extends Presenter.View {

        void showLogin();

        void showHome();
    }
}
