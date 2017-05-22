package com.bajicdusko.androidstarterkit.interactor;

import io.reactivex.Single;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27.04.17.
 */

public interface UseCase<M, P> {

    Single<M> execute(P p);
}
