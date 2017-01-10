package com.bajicdusko.androidstarterkit.core.rest.exception;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Sep-16.
 */

import android.content.Context;

import com.bajicdusko.androidstarterkit.R;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 24-Aug-16.
 */

public class NoConnectionException extends ApiException {
    public NoConnectionException(Context context) {
        super(context.getString(R.string.no_connection), 0);
    }
}