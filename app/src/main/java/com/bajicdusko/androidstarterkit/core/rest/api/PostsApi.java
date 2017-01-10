package com.bajicdusko.androidstarterkit.core.rest.api;

import com.bajicdusko.androidstarterkit.core.rest.model.posts.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public interface PostsApi {

    String POSTS = "posts";
    String ID_PATH = "{id}";
    String ID = "id";
    String PAGE = "page";
    String PER_PAGE = "per_page";
    String SEARCH = "filter[s]";
    String EMBED = "?_embed=true";

    @GET(POSTS + EMBED)
    Call<ArrayList<PostModel>> getAllPosts(@Query(PAGE) int page, @Query(PER_PAGE) int perPage);

    @GET(POSTS + EMBED)
    Call<ArrayList<PostModel>> getPosts(@Query(PAGE) int page, @Query(PER_PAGE) int perPage);

    @GET(POSTS + "/" + ID_PATH)
    Call<PostModel> getPost(@Path(ID) int id);

    @GET(POSTS + EMBED)
    Call<ArrayList<PostModel>> searchPosts(@Query(SEARCH) String search, @Query(PER_PAGE) int perPage);
}
