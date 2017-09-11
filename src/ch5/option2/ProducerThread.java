package ch5.option2;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread {
    private final Exchanger<char []> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProducerThread(Exchanger<char []> exchanger, char[] buffer, long seed) {
        super("ProducerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    System.out.println(Thread.currentThread().getName() + " : " + buffer[i]);
                }
                //System.out.println(Thread.currentThread().getName() + " :before exchange");
                buffer = exchanger.exchange(buffer);
                //System.out.println(Thread.currentThread().getName() + " :after exchange");
            }
        } catch (InterruptedException e) {}
    }

    private char nextChar() throws InterruptedException {
        char ch = (char)('A' + index%26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return ch;
    }
}
