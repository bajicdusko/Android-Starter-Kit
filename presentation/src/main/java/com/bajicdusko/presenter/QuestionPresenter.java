package com.bajicdusko.presenter;

import com.bajicdusko.androidstarterkit.model.SOQuestion;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public interface QuestionPresenter extends FragmentPresenter {

    void load();

    void onPause();

    void setView(View view);

    interface View extends FragmentPresenter.View {

        void showProgress();

        void hideProgress();

        void onDataChange(List<SOQuestion> soQuestions);

        void showError(String errorMessage);
    }
}
