package com.bajicdusko.androidrxstarterkit.ui;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.bajicdusko.androidrxstarterkit.Injector;
import com.bajicdusko.androidrxstarterkit.core.cache.CacheManager;
import com.bajicdusko.androidrxstarterkit.ui.fragment.IFragment;

import java.util.List;

public class FragmentUtility {

    private final String TAG = "FRAG_UTIL";
    private final int SINGLE_FRAGMENT = 1;

    private BaseActivity baseActivity;
    private int fragmentContainerId;
    private Injector injector;
    private CacheManager cacheManager;

    public FragmentUtility(BaseActivity baseActivity, int fragmentContainerId, CacheManager cacheManager) {
        this.baseActivity = baseActivity;
        this.injector = baseActivity;
        this.fragmentContainerId = fragmentContainerId;
        this.cacheManager = cacheManager;
    }

    public Fragment getFragment() {
        List<Fragment> fragments = baseActivity.getSupportFragmentManager().getFragments();
        if (fragments == null || fragments.size() > 0) {
            return fragments.get(0);
        }

        return null;
    }

    public void addFragment(Fragment fragment) {
        try {
            IFragment iFragment = (IFragment) fragment;
            baseActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .add(fragmentContainerId, fragment)
                    .addToBackStack(iFragment.getFragmentName())
                    .commit();
        } catch (ClassCastException ex) {
            Log.e(TAG, "Fragment does not implement IFragment");
        }
    }

    public void replaceFragment(Fragment fragment) {
        try {
            IFragment iFragment = (IFragment) fragment;
            baseActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragmentContainerId, fragment)
                    .addToBackStack(iFragment.getFragmentName())
                    .commit();
        } catch (ClassCastException ex) {
            Log.e(TAG, "Fragment does not implement IFragment");
        }
    }

    public boolean allowsBackpress() {
        return baseActivity.getSupportFragmentManager().getBackStackEntryCount() > SINGLE_FRAGMENT;
    }
}
