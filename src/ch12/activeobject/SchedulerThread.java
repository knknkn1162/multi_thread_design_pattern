package ch12.activeobject;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by knknkn on 2017/09/21.
 */
public class SchedulerThread extends Thread {
    private final ActivationQueue queue;
    public SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }

    public void invoke(MethodRequest request) {
        queue.putRequest(request);
    }

    public void run() {
        while(true) {
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
