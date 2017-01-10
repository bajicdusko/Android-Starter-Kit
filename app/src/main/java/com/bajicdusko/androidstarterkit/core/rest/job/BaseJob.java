package com.bajicdusko.androidstarterkit.core.rest.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public abstract class BaseJob extends Job {

    public BaseJob() {
        super(new Params(0).setRequiresNetwork(true));
    }
}
