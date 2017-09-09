package ch1; /**
 * Created by kenta_nakajima on 2017/09/09.
 */

public class Main {
    public static void main(String[] args) {
        //ThreadFactory fac = Executors.defaultThreadFactory();
        Bank bank = new Bank("kenta", 6001);
        for (int i = 0; i < 20; i++) {
            new Thread(new Threader(bank)).start();
        }
    }
}
