package com.bajicdusko.androidstarterkit.presentation.impl;

import com.bajicdusko.androidstarterkit.presentation.QuestionAdapterPresenter;
import com.bajicdusko.androidstarterkit.presentation.QuestionViewHolderPresenter;
import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionViewHolderPresenterImpl implements QuestionViewHolderPresenter {
    private int position;
    private QuestionAdapterPresenter questionAdapterPresenter;
    private View view;

    @Override
    public void setAdapterPresenter(QuestionAdapterPresenter questionAdapterPresenter) {
        this.questionAdapterPresenter = questionAdapterPresenter;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void bind() {
        SOQuestion question = questionAdapterPresenter.getQuestion(position);
        view.setTitle(question.getTitle());
        view.setQuestionUrl(question.getQuestionUrl());
        //TODO Wire other properties
    }
}
