package ch10.option2.barrier;

/**
 * Created by knknkn on 2017/09/19.
 */


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("begin");

        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        CyclicBarrier phaseBarrier = new CyclicBarrier(
                THREADS,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("barrier action !");
                    }
                }
        );

        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            for(int i = 0; i < THREADS; i++) {
                service.execute(new MyTask(phaseBarrier, doneLatch, i));
            }

            System.out.println("await");
            doneLatch.await();
        } catch (InterruptedException e) {

        } finally {
            service.shutdown();
            System.out.println("end");
        }
    }
}
