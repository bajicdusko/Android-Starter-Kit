package com.bajicdusko.androidboilerplate.core.rest.api;

import com.bajicdusko.androidboilerplate.core.rest.model.users.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public interface PostsApi {

    String POSTS = "posts";
    String ID_PATH = "{id}";
    String ID = "id";

    @GET(POSTS)
    Call<ArrayList<PostModel>> getPosts();

    @GET(POSTS + "/" + ID_PATH)
    Call<PostModel> getPost(@Path(ID) int id);
}
