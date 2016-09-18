package com.bajicdusko.androidboilerplate.core.rest.job.posts;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BaseJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.event.OnSearchPostsEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.posts.PostModel;
import com.bajicdusko.androidboilerplate.core.rest.services.base.APICallback;
import com.bajicdusko.androidboilerplate.core.rest.services.post.PostsService;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 24-Aug-16.
 */

public class SearchPostsJob extends BaseJob {

    @Inject
    PostsService postsService;
    @Inject
    Bus bus;

    private final String query;
    private final int perPage;

    public SearchPostsJob(String query, int perPage) {
        this.query = query;
        this.perPage = perPage;
    }

    @Override
    public void onAdded() {
        bus.post(OnSearchPostsEvent.eventInProgress());
    }

    @Override
    public void onRun() throws Throwable {
        postsService.searchPosts(query, perPage, new APICallback<ArrayList<PostModel>>() {
            @Override
            public void onSuccess(ArrayList<PostModel> response) {
                bus.post(OnSearchPostsEvent.finished(response));
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnSearchPostsEvent.error(ex));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnSearchPostsEvent.cancel());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
