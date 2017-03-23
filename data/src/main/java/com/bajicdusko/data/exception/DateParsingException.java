package com.bajicdusko.data.exception;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 02/03/17.
 */

public class DateParsingException extends RuntimeException {
    public DateParsingException(long dateValue, Exception e) {
        super(String.valueOf(dateValue), e);
    }
}
