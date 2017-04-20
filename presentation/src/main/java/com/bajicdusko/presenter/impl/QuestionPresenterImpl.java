package com.bajicdusko.presenter.impl;

import com.bajicdusko.data.Constants;
import com.bajicdusko.data.repository.QuestionRepository;
import com.bajicdusko.data.util.RXUtil;
import com.bajicdusko.data.util.Util;
import com.bajicdusko.presenter.QuestionPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class QuestionPresenterImpl implements QuestionPresenter {

    private final QuestionRepository questionRepository;
    private View view;
    private CompositeDisposable disposables;

    public QuestionPresenterImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void dispose() {
        RXUtil.dispose(disposables);
    }

    @Override
    public void load() {
        initDisposables();
        view.showProgress();
        Disposable disposable = questionRepository.getQuestionsByTag(Constants.ANDROID_TAG)
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

    private void initDisposables() {
        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
    }

    @Override
    public void onPause() {
        dispose();
    }
}
