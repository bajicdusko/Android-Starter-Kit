package com.bajicdusko.data.util;

import com.bajicdusko.data.exception.RetrofitException;

import io.reactivex.exceptions.CompositeException;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class Util {
    public static String getErrorMessage(Throwable throwable) {
        if (throwable instanceof RetrofitException) {
            return ((RetrofitException) throwable).getRetrofitErrorMessage();
        } else if (throwable instanceof CompositeException) {
            return ((CompositeException) throwable).getExceptions().get(0).getMessage();
        } else {
            return throwable.getMessage();
        }
    }
}
