package com.bajicdusko.androidboilerplate.core.rest.job.posts;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BaseJob;
import com.bajicdusko.androidboilerplate.core.rest.job.event.posts.OnGetPostsEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.users.PostModel;
import com.bajicdusko.androidboilerplate.core.rest.services.PostsService;
import com.bajicdusko.androidboilerplate.core.rest.services.base.APICallback;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class GetPostsJob extends BaseJob {

    @Inject
    PostsService postsService;
    @Inject
    Bus bus;

    private final int page;

    public GetPostsJob(int page) {
        super();
        this.page = page;
    }

    @Override
    public void onAdded() {
        bus.post(OnGetPostsEvent.eventInProgress());
    }

    @Override
    public void onRun() throws Throwable {
        postsService.getPosts(page, new APICallback<ArrayList<PostModel>>() {
            @Override
            public void onSuccess(ArrayList<PostModel> response) {
                bus.post(OnGetPostsEvent.finished(response, page));
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnGetPostsEvent.error(ex));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnGetPostsEvent.cancel());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
