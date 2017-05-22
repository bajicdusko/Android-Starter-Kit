package com.bajicdusko.androidstarterkit.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.di.adapter.AdapterComponent;
import com.bajicdusko.presenter.QuestionViewHolderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionViewHolder extends RecyclerView.ViewHolder implements QuestionViewHolderPresenter.View {
    public static final int LAYOUT_ID = R.layout.item_view_question;

    @BindView(R.id.item_view_question_tv_title)
    TextView tvTitle;
    @BindView(R.id.item_view_question_tv_url)
    TextView tvQuestionUrl;

    @Inject
    QuestionViewHolderPresenter questionViewHolderPresenter;

    public QuestionViewHolder(View itemView, AdapterComponent adapterComponent) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        adapterComponent.inject(this);
        questionViewHolderPresenter.setView(this);
    }

    public QuestionViewHolderPresenter getPresenter() {
        return questionViewHolderPresenter;
    }

    @Override
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setQuestionUrl(String questionUrl) {
        tvQuestionUrl.setText(questionUrl);
    }
}
