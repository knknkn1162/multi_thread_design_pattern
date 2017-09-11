package ch6.example;

/**
 * Created by knknkn on 2017/09/11.
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    private void slowly() {
        try { Thread.sleep(50);} catch (InterruptedException e) {}
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
        slowly();
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public char[] write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }


}
