package com.bajicdusko.androidboilerplate.core.rest.job.category.event;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.job.BasePagedEvent;
import com.bajicdusko.androidboilerplate.core.rest.model.category.CategoryModel;

import java.util.ArrayList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class OnGetCategoriesEvent extends BasePagedEvent {

    public final ArrayList<CategoryModel> categoryModels;

    public OnGetCategoriesEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, ArrayList<CategoryModel> categoryModels, int page) {
        super(apiException, isInProgress, isCanceled, page);
        this.categoryModels = categoryModels;
    }

    public static OnGetCategoriesEvent eventInProgress() {
        return new OnGetCategoriesEvent(null, true, false, null, NO_PAGE);
    }

    public static OnGetCategoriesEvent finished(ArrayList<CategoryModel> categoryModels, int page) {
        return new OnGetCategoriesEvent(null, false, false, categoryModels, page);
    }

    public static OnGetCategoriesEvent error(ApiException ex) {
        return new OnGetCategoriesEvent(ex, false, false, null, NO_PAGE);
    }

    public static OnGetCategoriesEvent cancel() {
        return new OnGetCategoriesEvent(null, false, true, null, NO_PAGE);
    }

}
