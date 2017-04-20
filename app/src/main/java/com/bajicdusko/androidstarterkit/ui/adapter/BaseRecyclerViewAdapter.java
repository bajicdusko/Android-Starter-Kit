package com.bajicdusko.androidstarterkit.ui.adapter;

import android.support.v7.widget.RecyclerView;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;
import com.bajicdusko.androidstarterkit.di.adapter.AdapterComponent;
import com.bajicdusko.androidstarterkit.di.adapter.AdapterModule;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 02/03/17.
 */

public abstract class BaseRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ActivityComponent activityComponent;

    public BaseRecyclerViewAdapter(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    public AdapterComponent injector() {
        return activityComponent.adapterBuilder().adapterModule(new AdapterModule()).build();
    }
}
