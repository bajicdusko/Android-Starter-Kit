package com.bajicdusko.data.api.model.stackoverflow;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class SOQuestion {

    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("owner")
    private Owner owner;
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
}
