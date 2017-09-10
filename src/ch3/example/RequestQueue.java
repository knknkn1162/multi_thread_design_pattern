package ch3.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */

import java.util.Queue;
import java.util.LinkedList;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest() {
        // if queue.head exists, it returns head element, or returns null.
        while (queue.peek() == null) { // guard suspension
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // ensure that queue.peek() cannot be null
        return proc();
    }

    private Request proc() {
        // do sth;
        return queue.remove();
    }


    public synchronized void putRequest(Request request) {
        // append request object to tail of queue.
        queue.offer(request);
        notifyAll();
    }
}
