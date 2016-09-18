package com.bajicdusko.androidboilerplate.core.rest.model.posts;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 17-Aug-16.
 */

public class PostModelList extends ArrayList<PostModel> implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public PostModelList() {
    }

    protected PostModelList(Parcel in) {
    }

    public static final Creator<PostModelList> CREATOR = new Creator<PostModelList>() {
        @Override
        public PostModelList createFromParcel(Parcel source) {
            return new PostModelList(source);
        }

        @Override
        public PostModelList[] newArray(int size) {
            return new PostModelList[size];
        }
    };
}
