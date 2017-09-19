package ch9.hint;

/**
 * Created by knknkn on 2017/09/19.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main:Begin");

        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread thread, Throwable exception) {
                        System.out.println("*** uncaught ***");
                    }
                }
        );


        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        System.out.println("*** shutdown *****");
                    }
                }
        );

        new Thread("MyThread") {
            public void run() {
                System.out.println("MyThread:begin");
                System.out.println("MyThread:sleep...");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                }

                System.out.println("MyThread:Devide");

                int x = 1/0;
                System.out.println("MyThread:end");
            }
        }.start();

        System.out.println("main:end");
    }
}
