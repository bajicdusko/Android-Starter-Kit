package com.bajicdusko.androidstarterkit.interactor;

import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.androidstarterkit.repository.QuestionRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public class GetQuestionsList implements UseCase<List<SOQuestion>, GetQuestionsList.Params> {
    private final QuestionRepository questionRepository;

    @Inject
    public GetQuestionsList(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Single<List<SOQuestion>> execute(Params params) {
        return questionRepository.getQuestionsByTag(params.tag);
    }

    public static class Params {
        private String tag;

        public Params(String tag) {
            this.tag = tag;
        }
    }
}
