package com.bajicdusko.androidboilerplate.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.bajicdusko.androidboilerplate.BoilerplateApplication;
import com.bajicdusko.androidboilerplate.BoilerplateDaggerComponent;
import com.bajicdusko.androidboilerplate.core.cache.CacheManager;
import com.bajicdusko.androidboilerplate.core.rest.ApiFactory;
import com.bajicdusko.androidboilerplate.core.rest.ApiModule;
import com.bajicdusko.androidboilerplate.core.rest.job.category.GetCategoriesJob;
import com.bajicdusko.androidboilerplate.core.rest.job.comment.GetCommentsJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.GetLatestPostJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.GetPostsJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.PostCommentJob;
import com.bajicdusko.androidboilerplate.core.rest.job.posts.SearchPostsJob;
import com.google.gson.Gson;
import com.path.android.jobqueue.BaseJob;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.di.DependencyInjector;
import com.path.android.jobqueue.log.CustomLogger;
import com.path.android.jobqueue.network.NetworkUtil;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Module(includes = {
        ApiModule.class
})
public class CoreModule {

    @Singleton
    @Provides
    public ApiFactory provideApiFactory(CacheManager cacheManager, Gson gson) {
        return new ApiFactory(gson);
    }

    @Singleton
    @Provides
    public CacheManager provideCacheManager(SharedPreferences sharedPreferences, Gson gson) {
        return new CacheManager(sharedPreferences, gson);
    }

    @Singleton
    @Provides
    public Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

    @Singleton
    @Provides
    public JobManager provideJobManager(final Context context) {
        Configuration configuration = new Configuration.Builder(context)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";

                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .networkUtil(new NetworkUtil() {
                    @Override
                    public boolean isConnected(Context context) {
                        return true;
                    }
                })
                .injector(new DependencyInjector() {
                    @Override
                    public void inject(BaseJob job) {
                        BoilerplateDaggerComponent component = ((BoilerplateApplication) context.getApplicationContext()).injector();
                        if (job instanceof GetPostsJob) {
                            component.inject((GetPostsJob) job);
                        } else if (job instanceof GetCategoriesJob) {
                            component.inject((GetCategoriesJob) job);
                        } else if (job instanceof GetCommentsJob) {
                            component.inject((GetCommentsJob) job);
                        } else if (job instanceof GetLatestPostJob) {
                            component.inject((GetLatestPostJob) job);
                        } else if (job instanceof PostCommentJob) {
                            component.inject((PostCommentJob) job);
                        } else if (job instanceof SearchPostsJob) {
                            component.inject((SearchPostsJob) job);
                        }
                    }
                })
                .build();
        return new JobManager(context, configuration);
    }
}
