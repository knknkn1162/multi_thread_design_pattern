package ch6.example;

/**
 * Created by knknkn on 2017/09/11.
 */


import java.util.Random;

public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filter;
    private int index = 0;

    public WriterThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    private char nextChar() {
        char c = filter.charAt(index);
        this.index = (index+1)%filter.length();

        return c;
    }

    public void run() {
        try {
            while(true) {
                char c = nextChar();
                data.write(c);
                System.out.println(Thread.currentThread().getName() + " writes " + c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {}
    }
}
