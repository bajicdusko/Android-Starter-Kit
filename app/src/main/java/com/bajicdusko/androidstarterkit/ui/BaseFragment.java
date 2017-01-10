package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bajicdusko.androidstarterkit.AndroidStarterKitDaggerComponent;
import com.bajicdusko.androidstarterkit.Injector;
import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.core.rest.job.BaseEvent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public abstract class BaseFragment extends Fragment implements Injector {

    private final int NO_LAYOUT = -1;

    @Inject
    Bus bus;

    protected int getContentLayout() {
        return NO_LAYOUT;
    }

    @Override
    public AndroidStarterKitDaggerComponent injector() {
        return ((Injector) getActivity()).injector();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentLayout() == NO_LAYOUT) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            View view = inflater.inflate(getContentLayout(), container, false);
            ButterKnife.bind(this, view);
            return view;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    public boolean areFieldsEmpty(EditText... args) {
        boolean fieldsEmpty = false;
        for (EditText arg : args) {
            String value = arg.getText().toString();
            if (TextUtils.isEmpty(value)) {
                arg.setError(getString(R.string.field_is_empty));
                fieldsEmpty = true;
            }
        }

        return fieldsEmpty;
    }

    public boolean shouldReadEventData(BaseEvent event) {
        if (!event.isInProgress()) {
            if (event.hasError()) {
                return false;
            }
            if (event.isCanceled()) {
                return false;
            }

            return true;
        }

        return false;
    }
}
