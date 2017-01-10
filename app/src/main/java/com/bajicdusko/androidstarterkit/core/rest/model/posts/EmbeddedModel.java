package com.bajicdusko.androidstarterkit.core.rest.model.posts;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.androidstarterkit.core.rest.model.BaseModel;
import com.bajicdusko.androidstarterkit.core.rest.model.user.UserModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 16-Aug-16.
 */

public class EmbeddedModel extends BaseModel implements Parcelable {

    @SerializedName("author")
    private ArrayList<UserModel> authors;
    @SerializedName("wp:term")
    private ArrayList<PostModelList> categories;

    public ArrayList<UserModel> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<UserModel> authors) {
        this.authors = authors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.authors);
        dest.writeTypedList(this.categories);
    }

    public EmbeddedModel() {
    }

    protected EmbeddedModel(Parcel in) {
        super(in);
        this.authors = in.createTypedArrayList(UserModel.CREATOR);
        this.categories = in.createTypedArrayList(PostModelList.CREATOR);
    }

    public static final Creator<EmbeddedModel> CREATOR = new Creator<EmbeddedModel>() {
        @Override
        public EmbeddedModel createFromParcel(Parcel source) {
            return new EmbeddedModel(source);
        }

        @Override
        public EmbeddedModel[] newArray(int size) {
            return new EmbeddedModel[size];
        }
    };
}
