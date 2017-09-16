package ch9.exercise4;

/**
 * Created by knknkn on 2017/09/16.
 */

import java.util.concurrent.ExecutionException;

public class FutureData implements Data {
    private RealData realdata = null;
    private boolean ready = false;
    private ExecutionException exception = null;

    public synchronized void setRealdata(RealData realdata) {
        if (ready) { return;}
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) { return; }

        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() throws ExecutionException {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        if (exception != null) {
            throw exception;
        }

        return realdata.getContent();
    }


}
