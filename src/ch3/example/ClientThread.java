package ch3.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */

import java.util.Random;
import java.util.concurrent.ThreadFactory;
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    // putRequest
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);

            System.out.println(Thread.currentThread().getName() + " requests " + request);

            requestQueue.putRequest(request);

            try {
                Thread.sleep(random.nextInt(100));

            } catch (InterruptedException e) {}
        }
    }
}
