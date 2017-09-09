package ch1;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

    private void check() {
        if (money < 0) {
            System.out.println("check : " + money);
        }
    }
    /**
     check function is called if not synchonized keyword.
      */
    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            sendMoney(10);
            check();
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    /**
     *
     * bit heavy function
     */
    private void sendMoney(int m) {

        try {
            Thread.sleep(10);
            money -= m;
        } catch (InterruptedException e) {}
    }

    public int getMoney() {
        return money;
    }
}
