package ch9.option1;

/**
 * Created by knknkn on 2017/09/16.
 */

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char ch) {
        System.out.println("request(" + count + ", " + ch + ") begin");

        FutureData future = new FutureData(
            new Callable<RealData>() {
                public RealData call() {
                    return new RealData(count, ch);
                }
            }
        );

        new Thread(future).start();

        System.out.println("request(" + count + ", " + ch + ") end");

        return future;
    }
}
