package com.bajicdusko.androidrxstarterkit.core.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 16-Aug-16.
 */

public class RenderedModel extends BaseModel implements Parcelable {

    @SerializedName("rendered")
    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.rendered);
    }

    public RenderedModel() {
    }

    protected RenderedModel(Parcel in) {
        super(in);
        this.rendered = in.readString();
    }

    public static final Creator<RenderedModel> CREATOR = new Creator<RenderedModel>() {
        @Override
        public RenderedModel createFromParcel(Parcel source) {
            return new RenderedModel(source);
        }

        @Override
        public RenderedModel[] newArray(int size) {
            return new RenderedModel[size];
        }
    };
}
