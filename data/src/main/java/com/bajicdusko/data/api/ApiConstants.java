package com.bajicdusko.data.api;

import com.bajicdusko.data.BuildConfig;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public class ApiConstants {

    public static String BASE_URL = BuildConfig.env + BuildConfig.domain + BuildConfig.apiVersion;
    public static final int NETWORK_EXCEPTION_CODE = -10;
    public static final int UNKNOWN_EXCEPTION_CODE = -11;
}
