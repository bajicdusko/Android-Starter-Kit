package com.bajicdusko.data.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 02/03/17.
 */

public class DateTimeUtil {

    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PRETTY_PATTERN = "dd.MM.yyyy HH:mm";
    public static final String TITLE_PATTERN = "dd MMM yyyy";
    public static final String REQUEST_DATE_FORMAT = "dd-MM-yyyy";

    public static String getRequestDateFormatted(DateTime date) {
        return date.toString(REQUEST_DATE_FORMAT);
    }

    public static String toString(DateTime dateTime) {
        return dateTime.toString(PATTERN);
    }

    public static DateTime toDateTime(String dateTime) {
        return DateTime.parse(dateTime, DateTimeFormat.forPattern(PATTERN));
    }

    public static String toPrettyString(DateTime time) {
        return time.toString(PRETTY_PATTERN);
    }

    public static String toTitleString(DateTime dateTime) {
        return dateTime.toString(TITLE_PATTERN);
    }

    public static DateTime toDateTimeFromMillis(long millis) {
        return new DateTime(millis);
    }
}
