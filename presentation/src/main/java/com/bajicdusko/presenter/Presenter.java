package com.bajicdusko.presenter;

import android.os.Bundle;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public interface Presenter {

    void dispose();

    void onSaveInstanceState(Bundle outState);

    void onRestoreInstanceState(Bundle outState);

    void restore();

    interface View {
        void dispose();

        void restore();
    }
}
