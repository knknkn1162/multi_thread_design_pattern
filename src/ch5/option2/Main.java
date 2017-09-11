package ch5.option2;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<char[]>();
        char[] buffer1 = new char[2];
        char[] buffer2 = new char[2];
        new ProducerThread(exchanger, buffer1, 315).start();
        new ConsumerThread(exchanger, buffer2, 316).start();
    }
}
