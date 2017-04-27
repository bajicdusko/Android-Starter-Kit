package com.bajicdusko.androidstarterkit.repository;

import com.bajicdusko.androidstarterkit.model.SOQuestion;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionRepository {

    Single<List<SOQuestion>> getQuestionsByTag(String tag);
}
