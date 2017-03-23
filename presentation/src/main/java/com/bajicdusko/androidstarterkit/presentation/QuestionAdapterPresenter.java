package com.bajicdusko.androidstarterkit.presentation;

import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;
import com.bajicdusko.presenter.Presenter;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionAdapterPresenter extends Presenter {

    int getCount();

    void onDataChange(List<SOQuestion> soQuestions);

    SOQuestion getQuestion(int position);

    void setView(View view);

    interface View extends Presenter.View {

        void notifyAdapter();
    }
}
