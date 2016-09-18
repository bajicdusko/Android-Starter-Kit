package com.bajicdusko.androidboilerplate.core.rest.services.category;

import com.bajicdusko.androidboilerplate.core.rest.api.CategoriesApi;
import com.bajicdusko.androidboilerplate.core.rest.model.category.CategoryModel;
import com.bajicdusko.androidboilerplate.core.rest.services.base.APICallback;
import com.bajicdusko.androidboilerplate.core.rest.services.base.BaseService;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class CategoryService extends BaseService {

    @Inject
    CategoriesApi categoriesApi;

    @Inject
    public CategoryService() {
    }

    public void getCategories(int page, int perPage, APICallback<ArrayList<CategoryModel>> categoryCallback) {
        Call<ArrayList<CategoryModel>> categoriesCall = categoriesApi.getCategories(page, perPage);
        categoriesCall.enqueue(convertCallback(categoryCallback));
    }
}
