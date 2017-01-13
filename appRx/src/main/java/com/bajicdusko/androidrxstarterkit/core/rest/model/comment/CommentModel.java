package com.bajicdusko.androidrxstarterkit.core.rest.model.comment;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.androidrxstarterkit.core.rest.model.BaseModel;
import com.bajicdusko.androidrxstarterkit.core.rest.model.RenderedModel;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CommentModel extends BaseModel implements Parcelable {

    @SerializedName("id")
    private long commentId;
    @SerializedName("post")
    private long postId;
    @SerializedName("parent")
    private long parent;
    @SerializedName("author")
    private long author;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("date")
    private Date date;
    @SerializedName("content")
    private RenderedModel content;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RenderedModel getContent() {
        return content;
    }

    public void setContent(RenderedModel content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.commentId);
        dest.writeLong(this.postId);
        dest.writeLong(this.parent);
        dest.writeLong(this.author);
        dest.writeString(this.authorName);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeParcelable(this.content, flags);
    }

    public CommentModel() {
    }

    protected CommentModel(Parcel in) {
        super(in);
        this.commentId = in.readLong();
        this.postId = in.readLong();
        this.parent = in.readLong();
        this.author = in.readLong();
        this.authorName = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.content = in.readParcelable(RenderedModel.class.getClassLoader());
    }

    public static final Creator<CommentModel> CREATOR = new Creator<CommentModel>() {
        @Override
        public CommentModel createFromParcel(Parcel source) {
            return new CommentModel(source);
        }

        @Override
        public CommentModel[] newArray(int size) {
            return new CommentModel[size];
        }
    };
}
