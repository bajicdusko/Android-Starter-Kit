package com.bajicdusko.androidboilerplate.core.rest.job;

import com.path.android.jobqueue.JobManager;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ManualQueuedJobManager<T extends BaseJob> {

    private JobManager jobManager;

    ConcurrentLinkedQueue<T> queuedJobs = new ConcurrentLinkedQueue<>();

    public ManualQueuedJobManager(JobManager jobManager) {
        this.jobManager = jobManager;
    }

    public void addJob(T job) {
        queuedJobs.add(job);
    }

    public void execute() {
        if (!queuedJobs.isEmpty()) {
            jobManager.addJob(queuedJobs.poll());
        }
    }
}
