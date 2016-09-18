package com.bajicdusko.androidboilerplate.core.rest.job.posts.event;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BaseEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.posts.PostModel;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class OnSearchPostsEvent extends BaseEvent {

    public final ArrayList<PostModel> posts;

    public OnSearchPostsEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, ArrayList<PostModel> posts) {
        super(apiException, isInProgress, isCanceled);
        this.posts = posts;
    }

    public static OnSearchPostsEvent eventInProgress() {
        return new OnSearchPostsEvent(null, true, false, null);
    }

    public static OnSearchPostsEvent finished(ArrayList<PostModel> posts) {
        return new OnSearchPostsEvent(null, false, false, posts);
    }

    public static OnSearchPostsEvent error(ApiException ex) {
        return new OnSearchPostsEvent(ex, false, false, null);
    }

    public static OnSearchPostsEvent cancel() {
        return new OnSearchPostsEvent(null, false, true, null);
    }
}
