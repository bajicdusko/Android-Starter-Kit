package com.bajicdusko.androidstarterkit.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.ui.BaseFragment;
import com.bajicdusko.androidstarterkit.ui.adapter.QuestionsAdapter;
import com.bajicdusko.androidstarterkit.ui.view.SimpleDividerItemDecoration;
import com.bajicdusko.data.api.model.stackoverflow.SOQuestion;
import com.bajicdusko.presenter.QuestionPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionFragment extends BaseFragment implements IFragment, QuestionPresenter.View {

    private static final String FRAGMENT_NAME = "Question";
    @Inject
    QuestionPresenter questionPresenter;

    @BindView(R.id.fragment_question_rv_main)
    RecyclerView rvMain;
    private QuestionsAdapter questionsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_question;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        questionPresenter.setView(this);
        rvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMain.addItemDecoration(new SimpleDividerItemDecoration(getContext(), R.drawable.line_divider, R.dimen.default_margin));
    }

    @Override
    public void onResume() {
        super.onResume();
        questionPresenter.load();
    }

    @Override
    public void onPause() {
        super.onPause();
        questionPresenter.onPause();
    }

    @Override
    public void dispose() {
        questionPresenter.dispose();
    }


    @Override
    public void onDataChange(List<SOQuestion> soQuestions) {
        if (questionsAdapter == null) {
            questionsAdapter = new QuestionsAdapter(injector());
        }

        if (rvMain.getAdapter() == null) {
            rvMain.setAdapter(questionsAdapter);
        }

        questionsAdapter.getQuestionAdapterPresenter().onDataChange(soQuestions);
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getFragmentName() {
        return FRAGMENT_NAME;
    }

    public static IFragment newInstance() {
        return new QuestionFragment();
    }
}
