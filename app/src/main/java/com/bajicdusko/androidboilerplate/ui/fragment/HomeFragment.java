package com.bajicdusko.androidboilerplate.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bajicdusko.androidboilerplate.R;
import com.bajicdusko.androidboilerplate.core.rest.job.event.posts.OnGetPostsEvent;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.GetPostsJob;
import com.bajicdusko.androidboilerplate.core.rest.model.users.PostModel;
import com.bajicdusko.androidboilerplate.ui.BaseActivity;
import com.bajicdusko.androidboilerplate.ui.BaseFragment;
import com.bajicdusko.androidboilerplate.ui.adapter.posts.PostsAdapter;
import com.bajicdusko.androidboilerplate.ui.util.Utility;
import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public class HomeFragment extends BaseFragment implements IFragment {

    private final String NAME = "HOME";

    @Inject
    JobManager jobManager;

    @BindView(R.id.fragment_home_rv_posts)
    RecyclerView rlPosts;

    PostsAdapter postsAdapter;
    ArrayList<PostModel> postModels = new ArrayList<PostModel>();

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        rlPosts.setAdapter(postsAdapter = new PostsAdapter(postModels, (BaseActivity) getActivity()));
        loadData();
    }

    private void loadData() {
        postsAdapter.onRefresh();
        jobManager.addJob(new GetPostsJob(1));
    }

    @Subscribe
    public void onGetPostsEvent(OnGetPostsEvent event) {
        if (shouldReadEventData(event)) {
            postsAdapter.onDataChanged(event.posts);
        } else if (event.hasError()) {
            Utility.showToast(getContext(), event.getErrorMessage());
        }
    }

    @Override
    public String getFragmentName() {
        return NAME;
    }
}
