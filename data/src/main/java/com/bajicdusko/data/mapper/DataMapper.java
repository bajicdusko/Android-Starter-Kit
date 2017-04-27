package com.bajicdusko.data.mapper;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

import com.bajicdusko.androidstarterkit.model.BaseModel;
import com.bajicdusko.data.api.model.BaseDataModel;

public interface DataMapper<M extends BaseModel, D extends BaseDataModel> {

    M transform(D d);

    D transform(M m);
}
