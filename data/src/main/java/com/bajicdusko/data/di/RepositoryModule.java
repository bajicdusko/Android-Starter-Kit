package com.bajicdusko.data.di;

import android.content.SharedPreferences;

import com.bajicdusko.data.api.questions.QuestionsApi;
import com.bajicdusko.data.repository.CacheRepository;
import com.bajicdusko.data.repository.QuestionRepository;
import com.bajicdusko.data.repository.impl.CacheRepositoryImpl;
import com.bajicdusko.data.repository.impl.QuestionRepositoryImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module
public class RepositoryModule {

    @Provides
    public CacheRepository provideCacheRepository(SharedPreferences sharedPreferences) {
        return new CacheRepositoryImpl(sharedPreferences);
    }

    @Provides
    public QuestionRepository provideQuestionRepository(QuestionsApi questionsApi) {
        return new QuestionRepositoryImpl(questionsApi);
    }
}
