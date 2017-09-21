package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
public class ActiveObjectFactory {
    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();

        ActivationQueue queue = new ActivationQueue();

        SchedulerThread scheduler = new SchedulerThread(queue);

        Proxy proxy = new Proxy(scheduler, servant);

        // takeRequest
        scheduler.start();
        return proxy;
    }
}
