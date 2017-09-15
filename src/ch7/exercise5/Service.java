package ch7.exercise5;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class Service {
    private static boolean working = false;
    // light proc.
    public static synchronized void service() {
        if (working) return; //balk
        working=true;
        new Thread() {
            public void run() {
                exec();
            }
        }.start();

    }


    private static void exec() {
        try {
            doService();
        } finally {
            working = false;
        }
    }

    private static void doService(){
        System.out.print("service");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("done.");
    }


}
