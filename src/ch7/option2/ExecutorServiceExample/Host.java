package ch7.option2.ExecutorServiceExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.Executor;
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char ch) {
        System.out.println("request( " + count + ", " + ch + ") begin");

        new Thread(
                new Runnable() {
                    public void run() {
                        helper.handle(count, ch);
                    }
                }
        ).start();

        System.out.println("request(" + count + ", " + ch + ") end");
    }
}
