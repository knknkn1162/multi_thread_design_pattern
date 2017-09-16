package ch7.exercise7;

/**
 * Created by kenta_nakajima on 2017/09/16.
 */
public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");

        magic(obj);

        System.out.println("Step 2");

        synchronized (obj) {
            System.out.println("Step 3(never reached here");
        }
    }

    private static void magic(Object obj) {
        new Thread() {
            public void run() {
                synchronized (obj) {
                    while (true) {
                        int a = obj.hashCode();
                    }
                }
            }
        }.start();
    }
}
