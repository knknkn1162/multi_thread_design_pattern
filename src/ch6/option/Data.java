package ch6.option;

/**
 * Created by knknkn on 2017/09/11.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        readLock.lock();

        try {
            return doRead();
        } finally {
            readLock.unlock();
        }
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for(int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];
        }

        slowly();
        return newBuf;
    }

    // the method works more slowly than doRead.
    private void doWrite(char ch) {
        for (int i =0 ; i < buffer.length; i++) {
            buffer[i] = ch;
            slowly();
        }
    }

    public void write(char ch) throws InterruptedException {
        writeLock.lock();
        try {
            doWrite(ch);
        } finally {
            writeLock.unlock();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {}
    }
}
