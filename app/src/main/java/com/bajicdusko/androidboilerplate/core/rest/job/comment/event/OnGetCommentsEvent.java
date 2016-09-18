package com.bajicdusko.androidboilerplate.core.rest.job.comment.event;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BasePagedEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.comment.CommentModel;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 19-Aug-16.
 */

public class OnGetCommentsEvent extends BasePagedEvent {

    public final ArrayList<CommentModel> comments;
    public final String eventId;

    public OnGetCommentsEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, int page, ArrayList<CommentModel> comments, String eventId) {
        super(apiException, isInProgress, isCanceled, page);
        this.comments = comments;
        this.eventId = eventId;
    }

    public static OnGetCommentsEvent eventInProgress(String eventId) {
        return new OnGetCommentsEvent(null, true, false, NO_PAGE, null, eventId);
    }

    public static OnGetCommentsEvent finished(ArrayList<CommentModel> comments, int page, String eventId) {
        return new OnGetCommentsEvent(null, false, false, page, comments, eventId);
    }

    public static OnGetCommentsEvent error(ApiException ex, String eventId) {
        return new OnGetCommentsEvent(ex, false, false, NO_PAGE, null, eventId);
    }

    public static OnGetCommentsEvent cancel(String eventId) {
        return new OnGetCommentsEvent(null, false, true, NO_PAGE, null, eventId);
    }
}
