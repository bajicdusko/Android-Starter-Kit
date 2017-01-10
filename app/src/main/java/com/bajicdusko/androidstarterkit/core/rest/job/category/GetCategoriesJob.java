package com.bajicdusko.androidstarterkit.core.rest.job.category;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;
import com.bajicdusko.androidstarterkit.core.rest.job.BaseJob;
import com.bajicdusko.androidstarterkit.core.rest.job.category.event.OnGetCategoriesEvent;
import com.bajicdusko.androidstarterkit.core.rest.model.category.CategoryModel;
import com.bajicdusko.androidstarterkit.core.rest.services.base.APICallback;
import com.bajicdusko.androidstarterkit.core.rest.services.category.CategoryService;
import com.squareup.otto.Bus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class GetCategoriesJob extends BaseJob {

    @Inject
    CategoryService categoryService;
    @Inject
    Bus bus;

    public final int page;
    public final int perPage;

    public GetCategoriesJob(int page, int perPage) {
        this.page = page;
        this.perPage = perPage;
    }

    @Override
    public void onAdded() {
        bus.post(OnGetCategoriesEvent.eventInProgress());
    }

    @Override
    public void onRun() throws Throwable {
        categoryService.getCategories(page, perPage, new APICallback<ArrayList<CategoryModel>>() {
            @Override
            public void onSuccess(ArrayList<CategoryModel> response) {
                bus.post(OnGetCategoriesEvent.finished(response, page));
            }

            @Override
            public void onFailure(ApiException ex) {
                bus.post(OnGetCategoriesEvent.error(ex));
            }
        });
    }

    @Override
    protected void onCancel() {
        bus.post(OnGetCategoriesEvent.cancel());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
