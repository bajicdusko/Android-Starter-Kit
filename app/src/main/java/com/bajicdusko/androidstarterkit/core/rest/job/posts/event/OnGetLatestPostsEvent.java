package com.bajicdusko.androidstarterkit.core.rest.job.posts.event;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;
import com.bajicdusko.androidstarterkit.core.rest.job.BasePagedEvent;
import com.bajicdusko.androidstarterkit.core.rest.model.posts.PostModel;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 17-Aug-16.
 */

public class OnGetLatestPostsEvent extends BasePagedEvent {

    public final ArrayList<PostModel> postModels;

    public OnGetLatestPostsEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, ArrayList<PostModel> postModels, int page) {
        super(apiException, isInProgress, isCanceled, page);
        this.postModels = postModels;
    }

    public static OnGetLatestPostsEvent eventInProgress() {
        return new OnGetLatestPostsEvent(null, true, false, null, NO_PAGE);
    }

    public static OnGetLatestPostsEvent finished(ArrayList<PostModel> postModels, int page) {
        return new OnGetLatestPostsEvent(null, false, false, postModels, page);
    }

    public static OnGetLatestPostsEvent error(ApiException ex) {
        return new OnGetLatestPostsEvent(ex, false, false, null, NO_PAGE);
    }

    public static OnGetLatestPostsEvent cancel() {
        return new OnGetLatestPostsEvent(null, false, false, null, NO_PAGE);
    }
}
