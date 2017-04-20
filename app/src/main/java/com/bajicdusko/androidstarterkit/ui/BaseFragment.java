package com.bajicdusko.androidstarterkit.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;
import com.bajicdusko.androidstarterkit.ui.fragment.FragmentChannel;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public abstract class BaseFragment extends Fragment {

    protected FragmentChannel fragmentChannel;

    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentChannel) {
            fragmentChannel = ((FragmentChannel) context);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (fragmentChannel == null && getParentFragment() != null && getParentFragment() instanceof FragmentChannel) {
            fragmentChannel = (FragmentChannel) getParentFragment();
        }

        if (fragmentChannel == null) {
            Timber.d("Parent does not implement FragmentChannel.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public ActivityComponent injector() {
        return ((BaseActivity) getContext()).injector();
    }
}
