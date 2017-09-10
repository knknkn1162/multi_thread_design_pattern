package ch3.exercise5;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */



import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest() {
        // if queue.head exists, it returns head element, or returns null.
        while (queue.peek() == null) { // guard suspension
            try {
                wait();
                System.out.println("exit wait");
            } catch (InterruptedException e) {
            }
        }
        // ensure that queue.peek() cannot be null
        return proc();
    }

    private Request proc() {
        Request q =  queue.remove();
        //do sth;
        return q;
    }


    public synchronized void putRequest(Request request) {
        // append request object to tail of queue.
        queue.offer(request);
        notifyAll();
    }
}
