package com.bajicdusko.data.repository.impl;

import com.bajicdusko.data.Constants;
import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;
import com.bajicdusko.data.api.questions.QuestionsApi;
import com.bajicdusko.data.repository.QuestionRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionsApi questionsApi;

    public QuestionRepositoryImpl(QuestionsApi questionsApi) {
        this.questionsApi = questionsApi;
    }

    @Override
    public Single<List<SOQuestion>> getQuestionsByTag(String tag) {
        return questionsApi.get(Constants.DEFAULT_PAGE, Constants.DEFAULT_PER_PAGE, tag)
                .singleOrError()
                .map(soQuestionWrapper -> soQuestionWrapper.getQuestions());
    }
}
