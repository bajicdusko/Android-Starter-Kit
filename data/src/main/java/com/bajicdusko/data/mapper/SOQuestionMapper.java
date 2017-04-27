package com.bajicdusko.data.mapper;

import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.data.api.model.stackoverflow.SOQuestionData;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public class SOQuestionMapper implements DataMapper<SOQuestion, SOQuestionData> {
    @Override
    public SOQuestion transform(SOQuestionData soQuestionData) {
        return SOQuestion.newBuilder()
                .withAnswerCount(soQuestionData.getAnswerCount())
                .withCreationDate(soQuestionData.getCreationDate())
                .withIsAnswered(soQuestionData.isAnswered())
                .withLastActivityDate(soQuestionData.getLastActivityDate())
                .withLastEditDate(soQuestionData.getLastEditDate())
                //.withOwner(soQuestionData.getOwnerData()) todo init owner mapper
                .withQuestionId(soQuestionData.getQuestionId())
                .withQuestionUrl(soQuestionData.getQuestionUrl())
                .withAnswerCount(soQuestionData.getAnswerCount())
                .withCreationDate(soQuestionData.getCreationDate())
                .withScore(soQuestionData.getScore())
                .withIsAnswered(soQuestionData.isAnswered())
                .withTags(soQuestionData.getTags())
                .withTitle(soQuestionData.getTitle())
                .withViewCount(soQuestionData.getViewCount())
                .build();

    }

    @Override
    public SOQuestionData transform(SOQuestion soQuestion) {
        return SOQuestionData.newBuilder()
                .withAnswerCount(soQuestion.getAnswerCount())
                .withCreationDate(soQuestion.getCreationDate())
                .withIsAnswered(soQuestion.isAnswered())
                .withLastActivityDate(soQuestion.getLastActivityDate())
                .withLastEditDate(soQuestion.getLastEditDate())
                //.withOwner(soQuestionData.getOwnerData()) todo init owner mapper
                .withQuestionId(soQuestion.getQuestionId())
                .withQuestionUrl(soQuestion.getQuestionUrl())
                .withAnswerCount(soQuestion.getAnswerCount())
                .withCreationDate(soQuestion.getCreationDate())
                .withScore(soQuestion.getScore())
                .withIsAnswered(soQuestion.isAnswered())
                .withTags(soQuestion.getTags())
                .withTitle(soQuestion.getTitle())
                .withViewCount(soQuestion.getViewCount())
                .build();
    }
}
