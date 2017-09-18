package ch1.exercise7;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */
public final class Mutex {
    private long locks = 0;
    private Thread owner = null;

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        // Guarded suspension
        while(locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        assert locks == 0 || owner == me;
        owner = me;
        locks++;
    }

    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        // balk
        if(locks == 0 || owner != me) {
            return;
        }
        assert locks > 0 && owner == me;
        locks--;

        if (locks == 0) {
            owner = null;
            notifyAll();
        }
    }
}
