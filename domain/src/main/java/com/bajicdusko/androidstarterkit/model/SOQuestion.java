package com.bajicdusko.androidstarterkit.model;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public class SOQuestion extends BaseModel {

    private List<String> tags;
    private Owner owner;
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

    public SOQuestion() {
    }

    private SOQuestion(Builder builder) {
        setTags(builder.tags);
        setOwner(builder.owner);
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
        private Owner owner;
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

        public Builder withOwner(Owner val) {
            owner = val;
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

        public SOQuestion build() {
            return new SOQuestion(this);
        }
    }
}
