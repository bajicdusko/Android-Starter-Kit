package com.bajicdusko.androidstarterkit;

import com.bajicdusko.androidstarterkit.core.CoreModule;
import com.bajicdusko.androidstarterkit.core.rest.job.category.GetCategoriesJob;
import com.bajicdusko.androidstarterkit.core.rest.job.comment.GetCommentsJob;
import com.bajicdusko.androidstarterkit.core.rest.job.posts.GetLatestPostJob;
import com.bajicdusko.androidstarterkit.core.rest.job.posts.GetPostsJob;
import com.bajicdusko.androidstarterkit.core.rest.job.posts.PostCommentJob;
import com.bajicdusko.androidstarterkit.core.rest.job.posts.SearchPostsJob;
import com.bajicdusko.androidstarterkit.ui.BaseActivity;
import com.bajicdusko.androidstarterkit.ui.FragmentUtility;
import com.bajicdusko.androidstarterkit.ui.activity.MainActivity;
import com.bajicdusko.androidstarterkit.ui.fragment.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Singleton
@Component(modules = {
        AndroidStarterKitModule.class,
        CoreModule.class
})
public interface AndroidStarterKitDaggerComponent {

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
