package com.bajicdusko.androidstarterkit.core.rest.model.category;

import android.os.Parcel;

import com.bajicdusko.androidstarterkit.core.rest.model.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class CategoryModel extends BaseModel {

    @SerializedName("id")
    private long categoryId;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    private boolean isGroup;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.categoryId);
        dest.writeString(this.name);
        dest.writeString(this.slug);
        dest.writeByte(this.isGroup ? (byte) 1 : (byte) 0);
    }

    public CategoryModel() {
    }

    protected CategoryModel(Parcel in) {
        super(in);
        this.categoryId = in.readLong();
        this.name = in.readString();
        this.slug = in.readString();
        this.isGroup = in.readByte() != 0;
    }

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel source) {
            return new CategoryModel(source);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };
}
