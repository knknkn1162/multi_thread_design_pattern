package ch7.option2.ThreadFactory;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */
import java.util.concurrent.ThreadFactory;
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                }
        );

        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');

        System.out.println("Main end");
    }
}
