package com.bajicdusko.androidstarterkit.di.activity;

import com.bajicdusko.androidstarterkit.di.adapter.AdapterComponent;
import com.bajicdusko.androidstarterkit.ui.HomeActivity;
import com.bajicdusko.androidstarterkit.ui.adapter.QuestionsAdapter;
import com.bajicdusko.androidstarterkit.ui.authentication.LoginFragment;
import com.bajicdusko.androidstarterkit.ui.fragment.QuestionFragment;

import dagger.Subcomponent;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    AdapterComponent.Builder adapterBuilder();

    void inject(HomeActivity homeActivity);

    void inject(QuestionFragment questionFragment);

    void inject(QuestionsAdapter questionsAdapter);

    void inject(LoginFragment loginFragment);

    @Subcomponent.Builder
    interface Builder {
        Builder activityModule(ActivityModule activityModule);

        ActivityComponent build();
    }
}
