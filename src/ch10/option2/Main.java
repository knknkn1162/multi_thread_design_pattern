package ch10.option2;

/**
 * Created by knknkn on 2017/09/19.
 */

import ch3.exercise5.TalkThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;

public class Main {

    private static final int TASKS = 10;

    public static void main(String[] args) {
        System.out.println("Begin");

        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch doneLatch = new CountDownLatch(TASKS);

        try {
            for(int i = 0 ; i < TASKS; i++) {
                service.execute(new MyTask(doneLatch, i));
            }

            System.out.println("wait start");
            doneLatch.await();
            System.out.println("wait end");
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("end");
        }
    }
}
