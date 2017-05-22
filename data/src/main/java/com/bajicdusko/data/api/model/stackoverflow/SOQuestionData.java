package com.bajicdusko.data.api.model.stackoverflow;

import com.bajicdusko.data.api.model.BaseDataModel;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class SOQuestionData extends BaseDataModel {

    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("owner")
    private OwnerData ownerData;
    @SerializedName("is_answered")
    private boolean isAnswered;
    @SerializedName("view_count")
    private int viewCount;
    @SerializedName("answer_count")
    private int answerCount;
    @SerializedName("score")
    private int score;
    @SerializedName("last_activity_date")
    private DateTime lastActivityDate;
    @SerializedName("last_edit_date")
    private DateTime lastEditDate;
    @SerializedName("creation_date")
    private DateTime creationDate;
    @SerializedName("question_id")
    private long questionId;
    @SerializedName("link")
    private String questionUrl;
    @SerializedName("title")
    private String title;

    private SOQuestionData(Builder builder) {
        setTags(builder.tags);
        setOwnerData(builder.ownerData);
        setAnswered(builder.isAnswered);
        setViewCount(builder.viewCount);
        setAnswerCount(builder.answerCount);
        setScore(builder.score);
        setLastActivityDate(builder.lastActivityDate);
        setLastEditDate(builder.lastEditDate);
        setCreationDate(builder.creationDate);
        setQuestionId(builder.questionId);
        setQuestionUrl(builder.questionUrl);
        setTitle(builder.title);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public OwnerData getOwnerData() {
        return ownerData;
    }

    public void setOwnerData(OwnerData ownerData) {
        this.ownerData = ownerData;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public DateTime getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(DateTime lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public DateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(DateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static final class Builder {
        private List<String> tags;
        private OwnerData ownerData;
        private boolean isAnswered;
        private int viewCount;
        private int answerCount;
        private int score;
        private DateTime lastActivityDate;
        private DateTime lastEditDate;
        private DateTime creationDate;
        private long questionId;
        private String questionUrl;
        private String title;

        private Builder() {
        }

        public Builder withTags(List<String> val) {
            tags = val;
            return this;
        }

        public Builder withOwnerData(OwnerData val) {
            ownerData = val;
            return this;
        }

        public Builder withIsAnswered(boolean val) {
            isAnswered = val;
            return this;
        }

        public Builder withViewCount(int val) {
            viewCount = val;
            return this;
        }

        public Builder withAnswerCount(int val) {
            answerCount = val;
            return this;
        }

        public Builder withScore(int val) {
            score = val;
            return this;
        }

        public Builder withLastActivityDate(DateTime val) {
            lastActivityDate = val;
            return this;
        }

        public Builder withLastEditDate(DateTime val) {
            lastEditDate = val;
            return this;
        }

        public Builder withCreationDate(DateTime val) {
            creationDate = val;
            return this;
        }

        public Builder withQuestionId(long val) {
            questionId = val;
            return this;
        }

        public Builder withQuestionUrl(String val) {
            questionUrl = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public SOQuestionData build() {
            return new SOQuestionData(this);
        }
    }
}
