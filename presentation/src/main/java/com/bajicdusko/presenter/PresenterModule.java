package com.bajicdusko.presenter;

import com.bajicdusko.androidstarterkit.interactor.GetQuestionsList;
import com.bajicdusko.androidstarterkit.repository.CacheRepository;
import com.bajicdusko.data.di.DataModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module(includes = {DataModule.class})
public class PresenterModule {

    @Provides
    public QuestionPresenter provideQuestionPresenter(GetQuestionsList getQuestionsList) {
        return new QuestionPresenter(getQuestionsList);
    }

    @Provides
    public QuestionAdapterPresenter provideQuestionAdapterPresenter() {
        return new QuestionAdapterPresenter();
    }

    @Provides
    public QuestionViewHolderPresenter provideQuestionViewHolderPresenter() {
        return new QuestionViewHolderPresenter();
    }

    @Provides
    public HomePresenter provideHomePresenter(CacheRepository cacheRepository) {
        return new HomePresenter(cacheRepository);
    }

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }
}
