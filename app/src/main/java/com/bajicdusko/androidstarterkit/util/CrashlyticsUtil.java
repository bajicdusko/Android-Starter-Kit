package com.bajicdusko.androidstarterkit.util;

import com.bajicdusko.androidstarterkit.BuildConfig;
import com.crashlytics.android.Crashlytics;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 04.05.17.
 */

public class CrashlyticsUtil {
    public static void log(Throwable throwable) {
        if (!BuildConfig.DEBUG && Crashlytics.getInstance() != null) {
            Crashlytics.getInstance().logException(throwable);
        }
    }

    public static void logMessage(String message) {
        if (!BuildConfig.DEBUG && Crashlytics.getInstance() != null) {
            Crashlytics.getInstance().log(message);
        }
    }

    public static void setUsername(String username) {
        if (!BuildConfig.DEBUG && Crashlytics.getInstance() != null) {
            Crashlytics.setUserName(username);
        }
    }
}
