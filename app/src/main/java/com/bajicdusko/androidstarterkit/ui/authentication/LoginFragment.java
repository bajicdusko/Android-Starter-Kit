package com.bajicdusko.androidstarterkit.ui.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.ui.BaseFragment;
import com.bajicdusko.androidstarterkit.ui.fragment.manager.IFragment;
import com.bajicdusko.presenter.LoginPresenter;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class LoginFragment extends BaseFragment implements IFragment, LoginPresenter.View {

    private static final String FRAGMENT_NAME = "Login";

    @Inject LoginPresenter loginPresenter;

    @BindView(R.id.fragment_login_container) ConstraintLayout clContainer;
    @BindView(R.id.fragment_login_iv_logo) ImageView ivLogo;
    @BindView(R.id.fragment_login_til_username) TextInputLayout tilUsername;
    @BindView(R.id.fragment_login_til_password) TextInputLayout tilPassword;
    @BindView(R.id.fragment_login_tet_username) TextInputEditText tetUsername;
    @BindView(R.id.fragment_login_tet_password) TextInputEditText tetPassword;
    @BindView(R.id.fragment_login_bt_login) Button btLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
        loginPresenter.setView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RxView.clicks(btLogin)
                .throttleFirst(2, TimeUnit.SECONDS)
                .filter(a -> {
                    boolean valid = true;
                    if (TextUtils.isEmpty(tetUsername.getText().toString())) {
                        tetUsername.setError(getString(R.string.field_cannot_be_empty));
                        valid = false;
                    }

                    if (TextUtils.isEmpty(tetUsername.getText().toString())) {
                        tetUsername.setError(getString(R.string.field_cannot_be_empty));
                        valid = false;
                    }

                    return valid;
                })
                .subscribe(a -> loginPresenter.onLogin(
                        tetUsername.getText().toString(),
                        tetPassword.getText().toString())
                );
    }

    @Override
    public void onResume() {
        super.onResume();
        if (fragmentChannel != null) {
            fragmentChannel.fadeOutToolbar();
        }
    }

    @Override
    public void dispose() {
        loginPresenter.dispose();
    }

    @Override
    public void restore() {

    }

    @Override
    public void setTitle() {

    }

    @Override
    public void onSuccessfulLogin() {
        if (fragmentChannel != null) {
            fragmentChannel.showHome();
        }
    }

    @Override
    public String getFragmentName() {
        return FRAGMENT_NAME;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }
}
