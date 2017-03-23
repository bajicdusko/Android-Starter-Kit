package com.bajicdusko.data.repository;

import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionRepository {

    Single<List<SOQuestion>> getQuestionsByTag(String tag);
}
