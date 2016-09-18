package com.bajicdusko.androidboilerplate.core.rest.api;

import com.bajicdusko.androidboilerplate.core.rest.model.comment.CommentModel;
import com.bajicdusko.androidboilerplate.core.rest.model.comment.CommentRequestModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CommentsApi {

    String COMMENTS = "comments";
    String PAGE = "page";
    String PER_PAGE = "per_page";
    String POST_ID = "post";
    String ORDER_BY_DATE_AND_PARENT = "filter[orderby]=date_gmt parent";

    @GET(COMMENTS + "?" + ORDER_BY_DATE_AND_PARENT)
    Call<ArrayList<CommentModel>> getComments(@Query(POST_ID) long postId, @Query(PAGE) int page, @Query(PER_PAGE) int perPage);

    @POST(COMMENTS)
    Call<Void> postComment(@Query(POST_ID) long postId, @Body CommentRequestModel commentRequestModel);
}
