package com.bajicdusko.androidstarterkit.core.rest.services.comment;

import com.bajicdusko.androidstarterkit.core.rest.api.CommentsApi;
import com.bajicdusko.androidstarterkit.core.rest.model.comment.CommentModel;
import com.bajicdusko.androidstarterkit.core.rest.model.comment.CommentRequestModel;
import com.bajicdusko.androidstarterkit.core.rest.services.base.APICallback;
import com.bajicdusko.androidstarterkit.core.rest.services.base.BaseService;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 19-Aug-16.
 */

public class CommentService extends BaseService {

    @Inject
    CommentsApi commentsApi;

    @Inject
    public CommentService() {
    }

    public void getComments(long postId, int page, int perPage, APICallback<ArrayList<CommentModel>> comments) {
        Call<ArrayList<CommentModel>> getCommentsCall = commentsApi.getComments(postId, page, perPage);
        getCommentsCall.enqueue(convertCallback(comments));
    }

    public void postComment(long postId, String username, String content, APICallback<Void> createCallback) {
        CommentRequestModel commentModel = new CommentRequestModel();
        commentModel.setAuthorName(username);
        commentModel.setPostId(postId);
        commentModel.setContent(content);
        Call<Void> postCommentsCall = commentsApi.postComment(postId, commentModel);
        postCommentsCall.enqueue(convertCallback(createCallback));
    }
}
