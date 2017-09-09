package ch1;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Printer implements Runnable {
    private String message;
    public Printer(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
