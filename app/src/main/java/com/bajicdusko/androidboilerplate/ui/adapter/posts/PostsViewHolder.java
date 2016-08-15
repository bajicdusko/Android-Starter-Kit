package com.bajicdusko.androidboilerplate.ui.adapter.posts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bajicdusko.androidboilerplate.R;
import com.bajicdusko.androidboilerplate.core.rest.model.users.PostModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class PostsViewHolder extends RecyclerView.ViewHolder {

    public static final int LAYOUT = R.layout.view_post_item;

    @BindView(R.id.view_post_item_tv_title)
    TextView tvTitle;
    @BindView(R.id.view_post_item_tv_content)
    TextView tvContent;

    PostModel postModel;

    public PostsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setPostModel(PostModel postModel) {
        this.postModel = postModel;
    }

    public void bind() {
        tvTitle.setText(postModel.getTitle());
        tvContent.setText(postModel.getContent());
    }
}
