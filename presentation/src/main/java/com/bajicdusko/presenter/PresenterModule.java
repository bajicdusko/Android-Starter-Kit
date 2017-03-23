package com.bajicdusko.presenter;

import com.bajicdusko.androidstarterkit.presentation.QuestionAdapterPresenter;
import com.bajicdusko.androidstarterkit.presentation.QuestionPresenter;
import com.bajicdusko.androidstarterkit.presentation.QuestionViewHolderPresenter;
import com.bajicdusko.androidstarterkit.presentation.impl.QuestionAdapterPresenterImpl;
import com.bajicdusko.androidstarterkit.presentation.impl.QuestionPresenterImpl;
import com.bajicdusko.androidstarterkit.presentation.impl.QuestionViewHolderPresenterImpl;
import com.bajicdusko.data.di.DataModule;
import com.bajicdusko.data.repository.QuestionRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module(includes = {DataModule.class})
public class PresenterModule {

    @Provides
    public QuestionPresenter provideQuestionPresenter(QuestionRepository questionRepository) {
        return new QuestionPresenterImpl(questionRepository);
    }

    @Provides
    public QuestionAdapterPresenter provideQuestionAdapterPresenter() {
        return new QuestionAdapterPresenterImpl();
    }

    @Provides
    public QuestionViewHolderPresenter provideQuestionViewHolderPresenter() {
        return new QuestionViewHolderPresenterImpl();
    }
}
