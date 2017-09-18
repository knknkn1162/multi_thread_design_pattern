package ch7.option2.ExecutorExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.Executor;


public class Main {
    public static void main(String[] args) {
        System.out.println("main begin");

        Host host = new Host(
                new Executor() {
                    public void execute(Runnable r) {
                        new Thread(r).start();
                    }
                }
        );

        host.request(10, 'A');
        host.request(20, 'B');

        host.request(30, 'C');

        System.out.println("main END");
    }
}
