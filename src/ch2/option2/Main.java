package ch2.option2;


import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */

class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + " : " + s);
    }
}

class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314514);

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }


    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("Begin: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End: used = " + (permits - semaphore.availablePermits()));
    }
}


class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while(true) {
                resource.use();
                Thread.sleep(random.nextInt(300));
            }
        } catch (InterruptedException e) {}
    }
}

public class Main {
    public static void main(String[] args) {
        BoundedResource resource = new BoundedResource(3);

        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}