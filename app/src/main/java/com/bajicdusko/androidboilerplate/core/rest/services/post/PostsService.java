package com.bajicdusko.androidboilerplate.core.rest.services.post;

import com.bajicdusko.androidboilerplate.core.rest.api.PostsApi;
import com.bajicdusko.androidboilerplate.core.rest.model.posts.PostModel;
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

    public void getAllPosts(int page, int perPage, APICallback<ArrayList<PostModel>> postsCallback) {
        Call<ArrayList<PostModel>> postsCall = postsApi.getAllPosts(page, perPage);
        postsCall.enqueue(convertCallback(postsCallback));
    }

    public void getPosts(int page, int perPage, APICallback<ArrayList<PostModel>> postsCallback) {
        Call<ArrayList<PostModel>> postsCall = postsApi.getPosts(page, perPage);
        postsCall.enqueue(convertCallback(postsCallback));
    }

    public void getPost(int id, APICallback<PostModel> postModelCallback) {
        Call<PostModel> postModelCall = postsApi.getPost(id);
        postModelCall.enqueue(convertCallback(postModelCallback));
    }

    public void searchPosts(String query, int perPage, APICallback<ArrayList<PostModel>> postsCallback) {
        Call<ArrayList<PostModel>> postModelsCall = postsApi.searchPosts(query, perPage);
        postModelsCall.enqueue(convertCallback(postsCallback));
    }
}
