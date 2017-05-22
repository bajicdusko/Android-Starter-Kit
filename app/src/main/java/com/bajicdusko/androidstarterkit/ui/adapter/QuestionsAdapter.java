package com.bajicdusko.androidstarterkit.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;
import com.bajicdusko.androidstarterkit.ui.adapter.viewholder.QuestionViewHolder;
import com.bajicdusko.data.Constants;
import com.bajicdusko.presenter.QuestionAdapterPresenter;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionsAdapter extends BaseRecyclerViewAdapter<QuestionViewHolder> implements QuestionAdapterPresenter.View {

    @Inject
    @Named(Constants.ACTIVITY_CONTEXT)
    Context context;
    @Inject
    QuestionAdapterPresenter questionAdapterPresenter;

    public QuestionsAdapter(ActivityComponent activityComponent) {
        super(activityComponent);
        activityComponent.inject(this);
        questionAdapterPresenter.setView(this);
    }

    public QuestionAdapterPresenter getQuestionAdapterPresenter() {
        return questionAdapterPresenter;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void restore() {

    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        QuestionViewHolder questionViewHolder =
                new QuestionViewHolder(LayoutInflater.from(context).inflate(QuestionViewHolder.LAYOUT_ID, parent, false), injector());
        questionViewHolder.getPresenter().setAdapterPresenter(questionAdapterPresenter);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        holder.getPresenter().setPosition(position);
        holder.getPresenter().bind();
    }

    @Override
    public int getItemCount() {
        return questionAdapterPresenter.getCount();
    }
}
