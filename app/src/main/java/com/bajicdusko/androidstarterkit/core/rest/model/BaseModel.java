package com.bajicdusko.androidstarterkit.core.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class BaseModel implements Parcelable {

    @SerializedName("error")
    private String error;
    @SerializedName("description")
    private String description;
    @SerializedName("code")
    private int code;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.error);
        dest.writeString(this.description);
        dest.writeInt(this.code);
    }

    public BaseModel() {
    }

    protected BaseModel(Parcel in) {
        this.error = in.readString();
        this.description = in.readString();
        this.code = in.readInt();
    }

}
