package com.bajicdusko.data.api.model;

import com.bajicdusko.data.api.model.stackoverflow.SOQuestionData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 24/03/2017.
 */

public class SOQuestionWrapper {

    @SerializedName("items")
    private List<SOQuestionData> questions;

    public List<SOQuestionData> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SOQuestionData> questions) {
        this.questions = questions;
    }
}
