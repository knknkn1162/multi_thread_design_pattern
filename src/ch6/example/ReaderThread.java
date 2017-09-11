package ch6.example;

/**
 * Created by knknkn on 2017/09/11.
 */

public class ReaderThread extends Thread{
    private final Data data;
    public ReaderThread(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            while(true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {}
    }
}
