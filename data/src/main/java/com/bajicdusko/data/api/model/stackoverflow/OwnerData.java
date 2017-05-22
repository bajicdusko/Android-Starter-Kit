package com.bajicdusko.data.api.model.stackoverflow;

import com.bajicdusko.data.api.model.BaseDataModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class OwnerData extends BaseDataModel {

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

    private OwnerData(Builder builder) {
        setReputation(builder.reputation);
        setUserId(builder.userId);
        setAvatar(builder.avatar);
        setDisplayName(builder.displayName);
        setProfileUrl(builder.profileUrl);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

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

    public static final class Builder {
        private int reputation;
        private long userId;
        private String avatar;
        private String displayName;
        private String profileUrl;

        private Builder() {
        }

        public Builder withReputation(int val) {
            reputation = val;
            return this;
        }

        public Builder withUserId(long val) {
            userId = val;
            return this;
        }

        public Builder withAvatar(String val) {
            avatar = val;
            return this;
        }

        public Builder withDisplayName(String val) {
            displayName = val;
            return this;
        }

        public Builder withProfileUrl(String val) {
            profileUrl = val;
            return this;
        }

        public OwnerData build() {
            return new OwnerData(this);
        }
    }
}
