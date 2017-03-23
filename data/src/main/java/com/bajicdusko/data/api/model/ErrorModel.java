package com.bajicdusko.data.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.data.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 21-Feb-17.
 */

public class ErrorModel implements Parcelable {
    @SerializedName("status")
    private String status;
    @SerializedName("errors")
    private HashMap<String, List<String>> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, List<String>> getErrors() {
        return errors;
    }

    public String getFirstError() {
        Collection<List<String>> errorLists = getSafeErrors().values();
        for (List<String> errorList : errorLists) {
            return errorList.get(0);
        }

        return "Unknown error occurred.";
    }

    private HashMap<String, List<String>> getSafeErrors() {
        if (getErrors() == null) {
            HashMap<String, List<String>> defaultError = new HashMap<>();
            List<String> errors = new ArrayList<>();
            errors.add("Unknown error occured.");
            defaultError.put(Constants.ERROR, errors);
            return defaultError;
        } else {
            return getErrors();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeSerializable(this.errors);
    }

    protected ErrorModel(Parcel in) {
        this.status = in.readString();
        this.errors = (HashMap<String, List<String>>) in.readSerializable();
    }

    public static final Creator<ErrorModel> CREATOR = new Creator<ErrorModel>() {
        @Override
        public ErrorModel createFromParcel(Parcel source) {
            return new ErrorModel(source);
        }

        @Override
        public ErrorModel[] newArray(int size) {
            return new ErrorModel[size];
        }
    };
}