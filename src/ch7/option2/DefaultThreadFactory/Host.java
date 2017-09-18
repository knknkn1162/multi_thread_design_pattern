package ch7.option2.DefaultThreadFactory;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */

import java.util.concurrent.ThreadFactory;

public class Host {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char ch) {
        System.out.println("request(" + count + ", " + ch + ") begin");

        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, ch);
                    }
                }
        ).start();

        System.out.println("request( " + count + ", " + ch + ") end");
    }
}
