package com.bajicdusko.androidstarterkit.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bajicdusko.androidstarterkit.R;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 10/03/17.
 */

public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private float paddingLeftRight = 0;

    public SimpleDividerItemDecoration(Context context) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
    }

    public SimpleDividerItemDecoration(Context context, @DrawableRes int dividerDrawable, @DimenRes int paddingLeftRight) {
        mDivider = ContextCompat.getDrawable(context, dividerDrawable);
        this.paddingLeftRight = context.getResources().getDimension(paddingLeftRight);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left, right;
        if (paddingLeftRight == 0) {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
        } else {
            left = (int) paddingLeftRight;
            right = parent.getWidth() - (int) paddingLeftRight;
        }

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
