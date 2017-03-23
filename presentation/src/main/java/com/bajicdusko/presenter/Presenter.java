package com.bajicdusko.presenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public interface Presenter {

    void dispose();

    interface View {
        void dispose();
    }
}
