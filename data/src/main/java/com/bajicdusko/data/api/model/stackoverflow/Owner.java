package com.bajicdusko.data.api.model.stackoverflow;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class Owner {

    @SerializedName("reputation")
    private int reputation;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("profile_image")
    private String avatar;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("link")
    private String profileUrl;

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
