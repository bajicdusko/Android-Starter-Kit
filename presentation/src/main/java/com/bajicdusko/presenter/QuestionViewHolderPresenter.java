package com.bajicdusko.presenter;

import android.os.Bundle;

import com.bajicdusko.androidstarterkit.model.SOQuestion;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionViewHolderPresenter implements Presenter {
    private int position;
    private QuestionAdapterPresenter questionAdapterPresenter;
    private View view;

    public void setAdapterPresenter(QuestionAdapterPresenter questionAdapterPresenter) {
        this.questionAdapterPresenter = questionAdapterPresenter;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void restore() {

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void bind() {
        SOQuestion question = questionAdapterPresenter.getQuestion(position);
        view.setTitle(question.getTitle());
        view.setQuestionUrl(question.getQuestionUrl());
        //TODO Wire other properties
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

    }

    public interface View {

        void setTitle(String title);

        void setQuestionUrl(String questionUrl);
    }
}
