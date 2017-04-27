package com.bajicdusko.data.exception;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public class MapperNotFoundException extends Throwable {
    public MapperNotFoundException(Class aClass) {
        super(aClass.getName());
    }
}
