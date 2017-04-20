package com.bajicdusko.androidstarterkit.ui.view;

import android.animation.Animator;
import android.view.View;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

public class Utils {

    private static final long FADE_DURATION = 250;

    public static void fadeIn(View view) {
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate().alpha(1f).setDuration(FADE_DURATION).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.animate().setListener(null);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    public static void fadeOut(View view) {
        view.animate().alpha(0f).setDuration(FADE_DURATION).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.INVISIBLE);
                view.animate().setListener(null);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

}
