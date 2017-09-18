package ch7.option2.ExecutorServiceExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main begin");
        ExecutorService executorService = Executors.newCachedThreadPool();

        Host host = new Host(
                executorService
        );

        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main end");
        }
    }
}
