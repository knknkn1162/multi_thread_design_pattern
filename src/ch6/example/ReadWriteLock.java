package ch6.example;

/**
 * Created by knknkn on 2017/09/11.
 */
public class ReadWriteLock {
    // number of thread on reading
    private int readingReaders = 0;
    // number of thread on waiting for write
    private int waitingWriters = 0;
    // number of thread on writing
    private int writingWriters = 0;
    //precede to write: 1
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    public synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }
}
