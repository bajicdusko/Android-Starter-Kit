package com.bajicdusko.androidboilerplate;

import com.bajicdusko.androidboilerplate.core.CoreModule;
import com.bajicdusko.androidboilerplate.core.rest.job.category.GetCategoriesJob;
import com.bajicdusko.androidboilerplate.core.rest.job.comment.GetCommentsJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.GetLatestPostJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.GetPostsJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.PostCommentJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.SearchPostsJob;
import com.bajicdusko.androidboilerplate.ui.BaseActivity;
import com.bajicdusko.androidboilerplate.ui.FragmentUtility;
import com.bajicdusko.androidboilerplate.ui.activity.MainActivity;
import com.bajicdusko.androidboilerplate.ui.fragment.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Singleton
@Component(modules = {
        BoilerplateModule.class,
        CoreModule.class
})
public interface BoilerplateDaggerComponent {

    void inject(BaseActivity activity);

    void inject(MainActivity activity);

    void inject(HomeFragment fragment);

    void inject(GetPostsJob job);

    void inject(GetCategoriesJob job);

    void inject(GetCommentsJob job);

    void inject(GetLatestPostJob job);

    void inject(PostCommentJob job);

    void inject(SearchPostsJob job);

    void inject(FragmentUtility fragmentUtility);
}
