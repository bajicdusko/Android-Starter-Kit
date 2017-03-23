package com.bajicdusko.androidstarterkit.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.bajicdusko.presenter.FragmentPresenter;

import java.util.List;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27/02/17.
 */

/**
 * EurekaFragmentManager is helper class for adding, replacing and removing fragments from stack.
 */
public class StarterKitFragmentManager {

    private FragmentManager fragmentManager;
    private int fragmentContainerId;

    public StarterKitFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void setFragmentContainerId(int fragmentContainerId) {
        this.fragmentContainerId = fragmentContainerId;
    }

    public void setFragmentContainerId(FrameLayout flContainer) {
        setFragmentContainerId(flContainer.getId());
    }

    public void addFragment(IFragment fragment) {
        fragmentManager.beginTransaction()
                .add(fragmentContainerId, (Fragment) fragment)
                .addToBackStack(null)
                .commit();
    }

    public void replaceFragment(IFragment fragment) {
        fragmentManager.beginTransaction()
                .replace(fragmentContainerId, (Fragment) fragment)
                .addToBackStack(fragment.getFragmentName())
                .commit();
    }

    /**
     * When activity backButton is pressed it is a good practice to override it and to use method
     * below. This method won't allow removal of last fragment on the stack.
     */
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
            getCurrentFragmentView().setTitle();
        }
    }

    public void popUp() {
        fragmentManager.popBackStackImmediate();
    }

    public void popUpAll() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * Returns currently displayed fragment on screen, having in mind that fragment could be popped
     * up just a moment ago.
     *
     * @return
     */
    public FragmentPresenter.View getCurrentFragmentView() {
        return (FragmentPresenter.View) getCurrentFragment();
    }

    public Fragment getCurrentFragment() {
        List<Fragment> fragments = fragmentManager.getFragments();
        return fragments.get(fragmentManager.getBackStackEntryCount() - 1);
    }

    public void disposeEverything() {
        getCurrentFragmentView().dispose();
    }
}
