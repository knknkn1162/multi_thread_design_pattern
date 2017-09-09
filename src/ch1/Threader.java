package ch1;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Threader implements Runnable {
    private Bank bank;
    public Threader(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        //int m = 3;
        for(int i = 0; i < 1000; i++) {
            boolean bool = bank.withdraw(3);
            System.out.println("bool: " + bool + " money : " + bank.getMoney() + "thread : " + Thread.currentThread().getName());
        }
    }


}
