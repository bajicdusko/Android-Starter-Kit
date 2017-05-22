package com.bajicdusko.data.mapper;

import com.bajicdusko.androidstarterkit.model.BaseModel;
import com.bajicdusko.androidstarterkit.model.Owner;
import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.data.api.model.BaseDataModel;
import com.bajicdusko.data.api.model.stackoverflow.OwnerData;
import com.bajicdusko.data.api.model.stackoverflow.SOQuestionData;
import com.bajicdusko.data.exception.MapperNotFoundException;

import timber.log.Timber;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public class MapperFactory {

    public static <D extends BaseDataModel> DataMapper create(D d) {
        if (d instanceof SOQuestionData) {
            return new SOQuestionMapper();
        } else if (d instanceof OwnerData) {
            return new OwnerMapper();
        } else {
            Timber.d(new MapperNotFoundException(d.getClass()));
            return null;
        }
    }

    public static <M extends BaseModel> DataMapper create(M m) {
        if (m instanceof SOQuestion) {
            return new SOQuestionMapper();
        } else if (m instanceof Owner) {
            return new OwnerMapper();
        } else {
            Timber.d(new MapperNotFoundException(m.getClass()));
            return null;
        }
    }
}
