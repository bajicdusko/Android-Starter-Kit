package com.bajicdusko.androidboilerplate.core.rest.model.comment;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.androidboilerplate.core.rest.model.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 19-Aug-16.
 */

public class CommentRequestModel extends BaseModel implements Parcelable {

    @SerializedName("post")
    private long postId;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("content")
    private String content;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
        dest.writeLong(this.postId);
        dest.writeString(this.authorName);
        dest.writeString(this.content);
    }

    public CommentRequestModel() {
    }

    protected CommentRequestModel(Parcel in) {
        super(in);
        this.postId = in.readLong();
        this.authorName = in.readString();
        this.content = in.readString();
    }

    public static final Creator<CommentRequestModel> CREATOR = new Creator<CommentRequestModel>() {
        @Override
        public CommentRequestModel createFromParcel(Parcel source) {
            return new CommentRequestModel(source);
        }

        @Override
        public CommentRequestModel[] newArray(int size) {
            return new CommentRequestModel[size];
        }
    };
}
