package com.bajicdusko.data.api.questions;

import com.bajicdusko.data.api.model.SOQuestionWrapper;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionsApi {

    String QUESTIONS = "questions";
    String SORTING = "?order=desc&sort=activity&site=stackoverflow";

    @GET(QUESTIONS + SORTING)
    Flowable<SOQuestionWrapper> get(@Query("page") int page, @Query("pagesize") int pageSize, @Query("tagged") String tag);
}
