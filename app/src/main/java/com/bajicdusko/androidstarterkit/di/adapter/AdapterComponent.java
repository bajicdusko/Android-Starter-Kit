package com.bajicdusko.androidstarterkit.di.adapter;

import com.bajicdusko.androidstarterkit.ui.adapter.viewholder.QuestionViewHolder;

import dagger.Subcomponent;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 02/03/17.
 */

@AdapterScope
@Subcomponent(modules = {AdapterModule.class})
public interface AdapterComponent {

    void inject(QuestionViewHolder questionViewHolder);

    @Subcomponent.Builder
    interface Builder {
        Builder adapterModule(AdapterModule adapterModule);

        AdapterComponent build();
    }
}
