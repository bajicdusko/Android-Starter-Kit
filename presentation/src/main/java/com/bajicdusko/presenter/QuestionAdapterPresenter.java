package com.bajicdusko.presenter;

import android.os.Bundle;

import com.bajicdusko.androidstarterkit.model.SOQuestion;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionAdapterPresenter implements Presenter {

    private static final String KEY_SO_QUESTIONS = "key_so_questions";
    private List<SOQuestion> soQuestions = new ArrayList<>();
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public void onDataChange(List<SOQuestion> soQuestions) {
        this.soQuestions = soQuestions;
        view.notifyAdapter();
    }

    public SOQuestion getQuestion(int position) {
        return soQuestions.get(position);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void restore() {
        view.notifyAdapter();
    }

    public int getCount() {
        return soQuestions.size();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (soQuestions != null) {
            outState.putParcelable(KEY_SO_QUESTIONS, Parcels.wrap(soQuestions));
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        if (outState != null) {
            soQuestions = Parcels.unwrap(outState.getParcelable(KEY_SO_QUESTIONS));
        }
    }

    public interface View extends Presenter.View {

        void notifyAdapter();
    }
}
