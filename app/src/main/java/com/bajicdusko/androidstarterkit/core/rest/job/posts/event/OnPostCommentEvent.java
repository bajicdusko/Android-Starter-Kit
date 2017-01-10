package com.bajicdusko.androidstarterkit.core.rest.job.posts.event;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;
import com.bajicdusko.androidstarterkit.core.rest.job.BaseEvent;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 24-Aug-16.
 */

public class OnPostCommentEvent extends BaseEvent {
    public OnPostCommentEvent(ApiException apiException, boolean isInProgress, boolean isCanceled) {
        super(apiException, isInProgress, isCanceled);
    }

    public static OnPostCommentEvent eventInProgress() {
        return new OnPostCommentEvent(null, true, false);
    }

    public static OnPostCommentEvent finished() {
        return new OnPostCommentEvent(null, false, false);
    }

    public static OnPostCommentEvent error(ApiException ex) {
        return new OnPostCommentEvent(ex, false, false);
    }

    public static OnPostCommentEvent canceled() {
        return new OnPostCommentEvent(null, false, true);
    }
}
