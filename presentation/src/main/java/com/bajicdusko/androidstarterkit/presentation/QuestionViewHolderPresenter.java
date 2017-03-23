package com.bajicdusko.androidstarterkit.presentation;

import com.bajicdusko.presenter.Presenter;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionViewHolderPresenter extends Presenter {

    void setPosition(int position);

    void bind();

    void setAdapterPresenter(QuestionAdapterPresenter questionAdapterPresenter);

    void setView(View view);

    interface View extends Presenter.View {

        void setTitle(String title);

        void setQuestionUrl(String questionUrl);
    }
}
