package com.bajicdusko.presenter;

import android.os.Bundle;

import com.bajicdusko.androidstarterkit.interactor.GetQuestionsList;
import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.data.Constants;
import com.bajicdusko.data.util.RXUtil;
import com.bajicdusko.data.util.Util;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionPresenter implements FragmentPresenter {

    private final GetQuestionsList getQuestionsList;
    private View view;
    private CompositeDisposable disposables;

    public QuestionPresenter(GetQuestionsList getQuestionsList) {
        this.getQuestionsList = getQuestionsList;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {
        RXUtil.dispose(disposables);
    }

    public void load() {
        initDisposables();
        view.showProgress();
        Disposable disposable = getQuestionsList.execute(new GetQuestionsList.Params(Constants.ANDROID_TAG))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(a -> view.hideProgress())
                .doOnError(a -> view.hideProgress())
                .subscribe(view::onDataChange, throwable -> {
                    Timber.e(throwable);
                    view.showError(Util.getErrorMessage(throwable));
                });

        disposables.add(disposable);
    }

    @Override
    public void restore() {
        view.restore();
    }

    private void initDisposables() {
        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
    }

    public void onPause() {
        dispose();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

    }

    public interface View extends FragmentPresenter.View {

        void showProgress();

        void hideProgress();

        void onDataChange(List<SOQuestion> soQuestions);

        void showError(String errorMessage);
    }
}
