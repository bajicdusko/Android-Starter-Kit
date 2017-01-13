package com.bajicdusko.androidrxstarterkit.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bajicdusko.androidrxstarterkit.R;
import com.bajicdusko.androidrxstarterkit.core.rest.ApiConstants;
import com.bajicdusko.androidrxstarterkit.core.rest.api.PostsApi;
import com.bajicdusko.androidrxstarterkit.ui.BaseActivity;
import com.bajicdusko.androidrxstarterkit.ui.BaseFragment;
import com.bajicdusko.androidrxstarterkit.ui.adapter.posts.PostsAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public class HomeFragment extends BaseFragment implements IFragment {

    private final String NAME = "HOME";

    @Inject
    PostsApi postsApi;

    @BindView(R.id.fragment_home_srl_main)
    SwipeRefreshLayout srlMain;
    @BindView(R.id.fragment_home_rv_posts)
    RecyclerView rlPosts;

    PostsAdapter postsAdapter;
    PublishProcessor<Integer> paginator;

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
        paginator = PublishProcessor.create();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        rlPosts.setAdapter(postsAdapter = new PostsAdapter((BaseActivity) getActivity()));

        Disposable paginatorDisposable = paginator
                .onBackpressureDrop()
                .doOnNext(page -> srlMain.setRefreshing(true))
                .map(page -> postsAdapter.getItemCount() / ApiConstants.DEFAULT_PER_PAGE + 1)
                .observeOn(Schedulers.io())
                .concatMap(page -> postsApi.getAllPosts(page, ApiConstants.DEFAULT_PER_PAGE)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally(() -> srlMain.setRefreshing(false)))
                .subscribe(
                        items -> postsAdapter.onDataChanged(items),
                        throwable -> Toast.makeText(getContext(), throwable.getClass().getName(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(getContext(), "Completed", Toast.LENGTH_SHORT).show()
                );

        Disposable pullToRefreshDisposable = Observable.create(o -> srlMain.setOnRefreshListener(() -> loadData())).subscribe();
        addDisposables(paginatorDisposable, pullToRefreshDisposable);
        loadData();
    }

    private void loadData() {
        postsAdapter.onRefresh();
        paginator.onNext(0);
    }

    @Override
    public String getFragmentName() {
        return NAME;
    }
}
