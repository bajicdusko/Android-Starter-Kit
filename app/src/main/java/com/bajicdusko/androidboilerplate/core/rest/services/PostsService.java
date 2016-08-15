package com.bajicdusko.androidboilerplate.core.rest.services;

import com.bajicdusko.androidboilerplate.core.rest.api.PostsApi;
import com.bajicdusko.androidboilerplate.core.rest.model.users.PostModel;
import com.bajicdusko.androidboilerplate.core.rest.services.base.APICallback;
import com.bajicdusko.androidboilerplate.core.rest.services.base.BaseService;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class PostsService extends BaseService {

    @Inject
    PostsApi postsApi;

    @Inject
    public PostsService() {

    }

    public void getPosts(int page, APICallback<ArrayList<PostModel>> postsCallback) {
        Call<ArrayList<PostModel>> postsCall = postsApi.getPosts();
        postsCall.enqueue(convertCallback(postsCallback));
    }

    public void getPost(int id, APICallback<PostModel> postModelCallback) {
        Call<PostModel> postModelCall = postsApi.getPost(id);
        postModelCall.enqueue(convertCallback(postModelCallback));
    }
}
