package com.bajicdusko.data.repository;

import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.androidstarterkit.repository.QuestionRepository;
import com.bajicdusko.data.Constants;
import com.bajicdusko.data.api.questions.QuestionsApi;
import com.bajicdusko.data.mapper.MapperFactory;

import java.util.List;

import io.reactivex.Flowable;
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
                .map(soQuestionWrapper -> soQuestionWrapper.getQuestions())
                .flatMap(Flowable::fromIterable)
                .map(soQuestionData -> ((SOQuestion) MapperFactory.create(soQuestionData).transform(soQuestionData)))
                .toList();
    }
}
