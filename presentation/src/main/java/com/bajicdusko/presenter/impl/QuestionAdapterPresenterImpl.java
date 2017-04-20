package com.bajicdusko.presenter.impl;

import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;
import com.bajicdusko.presenter.QuestionAdapterPresenter;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionAdapterPresenterImpl implements QuestionAdapterPresenter {

    private List<SOQuestion> soQuestions;
    private View view;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void onDataChange(List<SOQuestion> soQuestions) {
        this.soQuestions = soQuestions;
        view.notifyAdapter();
    }

    @Override
    public SOQuestion getQuestion(int position) {
        return soQuestions.get(position);
    }

    @Override
    public void dispose() {

    }

    @Override
    public int getCount() {
        return soQuestions.size();
    }
}
