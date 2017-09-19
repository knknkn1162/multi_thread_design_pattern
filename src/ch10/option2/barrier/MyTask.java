package ch10.option2.barrier;

/**
 * Created by knknkn on 2017/09/19.
 */

import java.util.Random;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable{
    private static final int PHASE = 5;
    private final CyclicBarrier phaseBarrier;
    private final CountDownLatch doneLatch;

    private final int context;
    private static final Random random = new Random(314);

    public MyTask(CyclicBarrier phaseBarrier, CountDownLatch doneLatch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.doneLatch = doneLatch;
        this.context = context;
    }

    protected void doPhase(int phase) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:begin:context = " + context + ", phase = " + phase);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
        } finally {
            System.out.println(name + "end" + context + "phase = " + phase);
        }
    }

    public void run() {
        try {
            for (int i = 0; i < PHASE; i++) {
                doPhase(i);
                phaseBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            doneLatch.countDown();
        }
    }
}
