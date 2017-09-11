package ch5.exercise9;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */
public class Something {
    public static void method(long x) throws InterruptedException {
        if (x != 0) {
            Object object = new Object();
            synchronized (object) {
                System.out.println("sync");
                object.wait(x);
            }
        }
    }
}
