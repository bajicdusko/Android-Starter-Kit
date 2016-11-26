package com.bajicdusko.androidboilerplate.core.rest.job.posts.event;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BasePagedEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.posts.PostModel;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class OnGetPostsEvent extends BasePagedEvent {

    public final ArrayList<PostModel> posts;

    public OnGetPostsEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, int page, ArrayList<PostModel> posts) {
        super(apiException, isInProgress, isCanceled, page);
        this.posts = posts;
    }

    public static OnGetPostsEvent eventInProgress() {
        return new OnGetPostsEvent(null, true, false, NO_PAGE, null);
    }

    public static OnGetPostsEvent finished(ArrayList<PostModel> posts, int page) {
        return new OnGetPostsEvent(null, false, false, page, posts);
    }

    public static OnGetPostsEvent error(ApiException ex) {
        return new OnGetPostsEvent(ex, false, false, NO_PAGE, null);
    }

    public static OnGetPostsEvent cancel() {
        return new OnGetPostsEvent(null, false, true, NO_PAGE, null);
    }
}
