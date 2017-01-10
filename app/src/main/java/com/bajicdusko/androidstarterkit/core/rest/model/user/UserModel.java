package com.bajicdusko.androidstarterkit.core.rest.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.androidstarterkit.core.rest.model.BaseModel;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 16-Aug-16.
 */

public class UserModel extends BaseModel implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar_urls")
    private HashMap<Integer, String> avatarUrls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(HashMap<Integer, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeSerializable(this.avatarUrls);
    }

    public UserModel() {
    }

    protected UserModel(Parcel in) {
        super(in);
        this.id = in.readInt();
        this.name = in.readString();
        this.avatarUrls = (HashMap<Integer, String>) in.readSerializable();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
