package Intro01;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class MyTest01 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }
}
