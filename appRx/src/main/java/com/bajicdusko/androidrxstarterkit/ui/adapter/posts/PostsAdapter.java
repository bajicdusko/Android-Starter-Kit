package com.bajicdusko.androidrxstarterkit.ui.adapter.posts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bajicdusko.androidrxstarterkit.core.rest.model.posts.PostModel;
import com.bajicdusko.androidrxstarterkit.ui.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {

    private ArrayList<PostModel> posts = new ArrayList<>();
    private BaseActivity baseActivity;

    public PostsAdapter(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    public void onRefresh() {
        this.posts.clear();
        notifyDataSetChanged();
    }

    public void onDataChanged(ArrayList<PostModel> postModels) {
        for (PostModel postModel : postModels) {
            if (!this.posts.contains(postModel)) {
                this.posts.add(postModel);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(baseActivity).inflate(PostsViewHolder.LAYOUT, parent, false));
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        holder.setPostModel(posts.get(position));
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
