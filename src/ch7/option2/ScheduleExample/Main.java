package ch7.option2.ScheduleExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) {
        System.out.println("main begin");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        Host host = new Host(
                scheduledExecutorService
        );

        try {
            host.request(10, 'A');
            host.request(20, 'B');

            host.request(30, 'C');
        } finally {
            scheduledExecutorService.shutdown();
            System.out.println("main end");
        }


    }
}
