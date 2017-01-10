package com.bajicdusko.androidstarterkit.core.rest.job.posts;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;
import com.bajicdusko.androidstarterkit.core.rest.job.BaseJob;
import com.bajicdusko.androidstarterkit.core.rest.job.posts.event.OnPostCommentEvent;
import com.bajicdusko.androidstarterkit.core.rest.services.base.APICallback;
import com.bajicdusko.androidstarterkit.core.rest.services.comment.CommentService;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 24-Aug-16.
 */

public class PostCommentJob extends BaseJob {

    @Inject
    CommentService commentService;
    @Inject
    Bus bus;

    private final long postId;
    private final String username;
    private final String comment;

    public PostCommentJob(long postId, String username, String comment) {
        this.postId = postId;
        this.username = username;
        this.comment = comment;
    }

    @Override
    public void onAdded() {
        bus.post(OnPostCommentEvent.eventInProgress());
    }

    @Override
    public void onRun() throws Throwable {
        commentService.postComment(postId, username, comment, new APICallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                bus.post(OnPostCommentEvent.finished());
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnPostCommentEvent.error(ex));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnPostCommentEvent.canceled());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
