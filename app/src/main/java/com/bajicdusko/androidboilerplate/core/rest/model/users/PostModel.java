package com.bajicdusko.androidboilerplate.core.rest.model.users;

import android.os.Parcel;

import com.bajicdusko.androidboilerplate.core.rest.model.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class PostModel extends BaseModel {

    @SerializedName("id")
    private int postId;
    @SerializedName("userId")
    private int userId;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String content;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.postId);
        dest.writeInt(this.userId);
        dest.writeString(this.title);
        dest.writeString(this.content);
    }

    public PostModel() {
    }

    protected PostModel(Parcel in) {
        super(in);
        this.postId = in.readInt();
        this.userId = in.readInt();
        this.title = in.readString();
        this.content = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel source) {
            return new PostModel(source);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };
}
