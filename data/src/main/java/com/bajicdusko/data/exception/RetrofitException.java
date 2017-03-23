package com.bajicdusko.data.exception;

import android.text.TextUtils;

import com.bajicdusko.data.api.ApiConstants;
import com.bajicdusko.data.api.model.ErrorModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 21-Feb-17.
 */

public class RetrofitException extends Exception {

    private Response response;
    private final int code;
    private String message;
    private final Retrofit retrofit;
    private final RetrofitErrorTypeEnum type;
    private List<String> backupErrorList;

    public RetrofitException(Response response, int code, String message, Retrofit retrofit, RetrofitErrorTypeEnum type) {
        this.response = response;
        this.code = code;
        this.message = message;
        this.retrofit = retrofit;
        this.type = type;
        backupErrorList = new ArrayList<>();
        backupErrorList.add(message);

        if (type == RetrofitErrorTypeEnum.HTTP) {
            extractHttpError();
        }
    }

    private void extractHttpError() {
        ErrorModel errorModel = null;

        /**
         * This is a chance to create ErrorModel for specific API and convert error body to it.
         * When {@link com.bajicdusko.data.util.Util.getErrorMessage()} is called it will use message
         * from ErrorModel for displaying purposes
         */

//        if (type == RetrofitErrorTypeEnum.HTTP && retrofit != null && response != null) {
//            try {
//                Converter<ResponseBody, ErrorModel> converter = retrofit.responseBodyConverter(ErrorModel.class, new Annotation[0]);
//                errorModel = converter.convert(response.errorBody());
//            } catch (IOException e) {
//            }
//        }

        if (errorModel != null) {
            this.message = errorModel.getFirstError();
        }
    }

    public String getRetrofitErrorMessage() {
        return message;
    }

    public RetrofitErrorTypeEnum getType() {
        return type;
    }

    public static RetrofitException httpException(Response response, Retrofit retrofit) {
        return new RetrofitException(response, response.code(), response.message(), retrofit, RetrofitErrorTypeEnum.HTTP);
    }

    public static RetrofitException networkException(IOException ioException) {
        return new RetrofitException(null, ApiConstants.NETWORK_EXCEPTION_CODE, ioException.getMessage(), null, RetrofitErrorTypeEnum.NETWORK);
    }

    public static RetrofitException unknownException(Throwable throwable) {
        String message = TextUtils.isEmpty(throwable.getMessage()) ? throwable.getClass().getName() : throwable.getMessage();
        return new RetrofitException(null, ApiConstants.UNKNOWN_EXCEPTION_CODE, message, null, RetrofitErrorTypeEnum.UNKNOWN);
    }

    public enum RetrofitErrorTypeEnum {
        HTTP,
        NETWORK,
        UNKNOWN
    }
}
