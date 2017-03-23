package com.bajicdusko.data;

import com.bajicdusko.data.exception.RetrofitException;

import org.reactivestreams.Publisher;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 21-Feb-17.
 */

public class RxJava2ErrorHandlerCallAdapterFactory extends CallAdapter.Factory {

    private final RxJava2CallAdapterFactory original;

    public RxJava2ErrorHandlerCallAdapterFactory() {
        original = RxJava2CallAdapterFactory.create();
    }

    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new RxJava2ErrorAdapterWrapper(retrofit, original.get(type, annotations, retrofit));
    }

    public static class RxJava2ErrorAdapterWrapper<R> implements CallAdapter<R, Flowable<?>> {

        private final Retrofit retrofit;
        private final CallAdapter<R, ?> wrapped;


        public RxJava2ErrorAdapterWrapper(Retrofit retrofit, CallAdapter<R, ?> wrapped) {
            this.retrofit = retrofit;
            this.wrapped = wrapped;
        }

        @Override
        public Type responseType() {
            return wrapped.responseType();
        }

        @Override
        public Flowable<?> adapt(Call<R> call) {
            return ((Flowable) wrapped.adapt(call)).onErrorResumeNext(new Function<Throwable, Publisher>() {
                @Override
                public Publisher apply(Throwable throwable) throws Exception {
                    RetrofitException retrofitException;
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        retrofitException = RetrofitException.httpException(httpException.response(), retrofit);
                    } else if (throwable instanceof IOException) {
                        retrofitException = RetrofitException.networkException((IOException) throwable);
                    } else {
                        retrofitException = RetrofitException.unknownException(throwable);
                    }

                    return Flowable.error(retrofitException);
                }
            });
        }
    }
}
