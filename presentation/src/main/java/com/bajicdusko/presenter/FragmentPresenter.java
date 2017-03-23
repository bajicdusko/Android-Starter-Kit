package com.bajicdusko.presenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface FragmentPresenter extends Presenter {

    interface View extends Presenter.View {

        void setTitle();
    }
}
