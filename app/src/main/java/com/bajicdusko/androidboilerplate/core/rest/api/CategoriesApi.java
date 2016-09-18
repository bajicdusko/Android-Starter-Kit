package com.bajicdusko.androidboilerplate.core.rest.api;

import com.bajicdusko.androidboilerplate.core.rest.model.category.CategoryModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public interface CategoriesApi {

    String PAGE = "page";
    String PER_PAGE = "per_page";
    String CATEGORIES = "categories";
    String ORDER_BY_DESCRIPTION = "?orderby=description";

    @GET(CATEGORIES + ORDER_BY_DESCRIPTION)
    Call<ArrayList<CategoryModel>> getCategories(@Query(PAGE) int page, @Query(PER_PAGE) int perPage);
}
