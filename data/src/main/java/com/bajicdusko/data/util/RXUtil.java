package com.bajicdusko.data.util;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 22/03/17.
 */

public class RXUtil {
    public static void dispose(CompositeDisposable disposables) {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
