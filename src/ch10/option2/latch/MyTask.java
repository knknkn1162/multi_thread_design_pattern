package ch10.option2.latch;

/**
 * Created by knknkn on 2017/09/19.
 */
import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class MyTask implements Runnable {
    private final CountDownLatch doneLatch;
    private final int context;

    private static final Random random = new Random(123);

    public MyTask(CountDownLatch doneLach, int context) {
        this.doneLatch = doneLach;
        this.context = context;
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "Mytask:begin:context = " + context);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            System.out.println(name + "end" + context);
        }
    }

    public void run() {
        doTask();
        doneLatch.countDown();
    }
}
