package com.bajicdusko.androidrxstarterkit.core.rest.api;

import com.bajicdusko.androidrxstarterkit.core.rest.model.posts.PostModel;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jan-17.
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
    Flowable<ArrayList<PostModel>> getAllPosts(@Query(PAGE) int page, @Query(PER_PAGE) int perPage);

    @GET(POSTS + EMBED)
    Observable<ArrayList<PostModel>> getPosts(@Query(PAGE) int page, @Query(PER_PAGE) int perPage);

    @GET(POSTS + "/" + ID_PATH)
    Observable<PostModel> getPost(@Path(ID) int id);

    @GET(POSTS + EMBED)
    Observable<ArrayList<PostModel>> searchPosts(@Query(SEARCH) String search, @Query(PER_PAGE) int perPage);
}
