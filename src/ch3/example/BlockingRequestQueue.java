package ch3.example;

/**
 * Created by knknkn on 2017/09/10.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingRequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() {
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException e) {}
        return req;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);

        } catch (InterruptedException e) {}
    }
}
