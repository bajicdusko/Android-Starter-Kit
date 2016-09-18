package com.bajicdusko.androidboilerplate.core.rest.job.posts;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BaseJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.event.OnGetLatestPostsEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.posts.PostModel;
import com.bajicdusko.androidboilerplate.core.rest.services.base.APICallback;
import com.bajicdusko.androidboilerplate.core.rest.services.post.PostsService;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 17-Aug-16.
 */

public class GetLatestPostJob extends BaseJob {

    @Inject
    PostsService postsService;
    @Inject
    Bus bus;

    private final int page;
    private final int perPage;

    public GetLatestPostJob(int page, int perPage) {
        super();
        this.perPage = perPage;
        this.page = page;
    }

    @Override
    public void onAdded() {
        bus.post(OnGetLatestPostsEvent.eventInProgress());
    }

    @Override
    public void onRun() throws Throwable {
        postsService.getAllPosts(page, perPage, new APICallback<ArrayList<PostModel>>() {
            @Override
            public void onSuccess(ArrayList<PostModel> response) {
                bus.post(OnGetLatestPostsEvent.finished(response, page));
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnGetLatestPostsEvent.error(ex));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnGetLatestPostsEvent.cancel());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
