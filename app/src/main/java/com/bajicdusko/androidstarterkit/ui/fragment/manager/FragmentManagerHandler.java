package com.bajicdusko.androidstarterkit.ui.fragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.bajicdusko.presenter.FragmentPresenter;

import org.parceler.Parcels;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27/02/17.
 */

/**
 * EurekaFragmentManager is helper class for adding, replacing and removing fragments from stack.
 */
public class FragmentManagerHandler {

    private static final String KEY_TAGS = "key_tags";
    private FragmentManager fragmentManager;
    private int fragmentContainerId;
    private FragmentTagStack fragmentTagStack;

    public FragmentManagerHandler(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        fragmentTagStack = new FragmentTagStack();
    }

    public void setFragmentContainerId(int fragmentContainerId) {
        this.fragmentContainerId = fragmentContainerId;
    }

    public void setFragmentContainerId(FrameLayout flContainer) {
        setFragmentContainerId(flContainer.getId());
    }

    public void addFragment(IFragment fragment) {
        fragmentTagStack.push(fragment.getFragmentName());
        fragmentManager.beginTransaction()
                .add(fragmentContainerId, (Fragment) fragment)
                .addToBackStack(null)
                .commit();
    }

    public void replaceFragment(IFragment fragment) {
        fragmentTagStack.push(fragment.getFragmentName());
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
            popUp();
            FragmentPresenter.View currentFragmentView = getCurrentFragmentView();
            if (currentFragmentView != null) {
                currentFragmentView.setTitle();
            }
        }
    }

    public void popUp() {
        fragmentManager.popBackStackImmediate();
        fragmentTagStack.pop();
    }

    public void popUpAll() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTagStack.popUpAll();
    }

    /**
     * Returns currently displayed fragment on screen, having in mind that fragment could be popped
     * up just a moment ago.
     *
     * @return
     */
    public FragmentPresenter.View getCurrentFragmentView() {
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            return (FragmentPresenter.View) currentFragment;
        } else {
            return null;
        }
    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentByTag(fragmentTagStack.getActiveTag());
    }

    public void disposeEverything() {
        FragmentPresenter.View currentFragmentView = getCurrentFragmentView();
        if (currentFragmentView != null) {
            currentFragmentView.dispose();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_TAGS, Parcels.wrap(fragmentTagStack));
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            fragmentTagStack = Parcels.unwrap(savedInstanceState.getParcelable(KEY_TAGS));
        } else {
            fragmentTagStack = new FragmentTagStack();
        }
    }
}
