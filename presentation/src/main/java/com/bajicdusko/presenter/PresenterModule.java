package com.bajicdusko.presenter;

import com.bajicdusko.data.di.DataModule;
import com.bajicdusko.data.repository.CacheRepository;
import com.bajicdusko.data.repository.QuestionRepository;
import com.bajicdusko.presenter.impl.HomePresenterImpl;
import com.bajicdusko.presenter.impl.LoginPresenterImpl;
import com.bajicdusko.presenter.impl.QuestionAdapterPresenterImpl;
import com.bajicdusko.presenter.impl.QuestionPresenterImpl;
import com.bajicdusko.presenter.impl.QuestionViewHolderPresenterImpl;

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

    @Provides
    public HomePresenter provideHomePresenter(CacheRepository cacheRepository) {
        return new HomePresenterImpl(cacheRepository);
    }

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl();
    }
}
