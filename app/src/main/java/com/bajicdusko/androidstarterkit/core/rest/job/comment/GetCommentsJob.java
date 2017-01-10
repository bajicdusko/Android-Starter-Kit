package com.bajicdusko.androidstarterkit.core.rest.job.comment;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;
import com.bajicdusko.androidstarterkit.core.rest.job.BaseJob;
import com.bajicdusko.androidstarterkit.core.rest.job.comment.event.OnGetCommentsEvent;
import com.bajicdusko.androidstarterkit.core.rest.model.comment.CommentModel;
import com.bajicdusko.androidstarterkit.core.rest.services.base.APICallback;
import com.bajicdusko.androidstarterkit.core.rest.services.comment.CommentService;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 19-Aug-16.
 */

public class GetCommentsJob extends BaseJob {

    @Inject
    CommentService commentService;
    @Inject
    Bus bus;

    public final long postId;
    public final int page;
    public final int perPage;
    public final String eventId;

    public GetCommentsJob(long postId, String eventId, int page, int perPage) {
        super();
        this.postId = postId;
        this.page = page;
        this.perPage = perPage;
        this.eventId = eventId;
    }

    @Override
    public void onAdded() {
        bus.post(OnGetCommentsEvent.eventInProgress(eventId));
    }

    @Override
    public void onRun() throws Throwable {
        commentService.getComments(postId, page, perPage, new APICallback<ArrayList<CommentModel>>() {
            @Override
            public void onSuccess(ArrayList<CommentModel> response) {
                bus.post(OnGetCommentsEvent.finished(response, page, eventId));
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnGetCommentsEvent.error(ex, eventId));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnGetCommentsEvent.cancel(eventId));
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
