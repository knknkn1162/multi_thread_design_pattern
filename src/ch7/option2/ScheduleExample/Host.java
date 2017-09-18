package ch7.option2.ScheduleExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Host {

    private final Helper helper = new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public Host(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void request(final int count, final char ch) {
        System.out.println("request(" + count + ", " + ch + ") begin");

        scheduledExecutorService.schedule(
                new Runnable() {
                    public void run() {
                        helper.handle(count, ch);
                    }
                }, 3L, TimeUnit.SECONDS
        );

        System.out.println("request( " + count + ", " + ch + ") end");
    }
}
