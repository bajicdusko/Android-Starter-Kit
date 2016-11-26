package com.bajicdusko.androidboilerplate.core.rest.model.posts;

import android.os.Parcel;
import android.os.Parcelable;

import com.bajicdusko.androidboilerplate.core.rest.model.BaseModel;
import com.bajicdusko.androidboilerplate.core.rest.model.RenderedModel;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 16-Aug-16.
 */

public class PostModel extends BaseModel implements Parcelable {

    @SerializedName("id")
    private long id;
    @SerializedName("date")
    private Date date;
    @SerializedName("modified")
    private Date modified;
    @SerializedName("slug")
    private String slug;
    @SerializedName("link")
    private String postUrl;
    @SerializedName("title")
    private RenderedModel title;
    @SerializedName("content")
    private RenderedModel content;
    @SerializedName("excerpt")
    private RenderedModel intro;
    @SerializedName("_embedded")
    private EmbeddedModel embeddedModel;
    @SerializedName("name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public RenderedModel getTitle() {
        return title;
    }

    public void setTitle(RenderedModel title) {
        this.title = title;
    }

    public RenderedModel getIntro() {
        return intro;
    }

    public void setIntro(RenderedModel intro) {
        this.intro = intro;
    }

    public EmbeddedModel getEmbeddedModel() {
        return embeddedModel;
    }

    public void setEmbeddedModel(EmbeddedModel embeddedModel) {
        this.embeddedModel = embeddedModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(RenderedModel content) {
        this.content = content;
    }

    public RenderedModel getContent() {
        return content;
    }

    public boolean equals(PostModel postModel) {
        return postModel != null && postModel.getId() == this.getId();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.id);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeLong(this.modified != null ? this.modified.getTime() : -1);
        dest.writeString(this.slug);
        dest.writeString(this.postUrl);
        dest.writeParcelable(this.title, flags);
        dest.writeParcelable(this.content, flags);
        dest.writeParcelable(this.intro, flags);
        dest.writeParcelable(this.embeddedModel, flags);
        dest.writeString(this.name);
    }

    public PostModel() {
    }

    protected PostModel(Parcel in) {
        super(in);
        this.id = in.readLong();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        long tmpModified = in.readLong();
        this.modified = tmpModified == -1 ? null : new Date(tmpModified);
        this.slug = in.readString();
        this.postUrl = in.readString();
        this.title = in.readParcelable(RenderedModel.class.getClassLoader());
        this.content = in.readParcelable(RenderedModel.class.getClassLoader());
        this.intro = in.readParcelable(RenderedModel.class.getClassLoader());
        this.embeddedModel = in.readParcelable(EmbeddedModel.class.getClassLoader());
        this.name = in.readString();
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