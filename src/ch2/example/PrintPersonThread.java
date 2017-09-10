package ch2.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */
public class PrintPersonThread extends Thread {
    private Person person;
    public PrintPersonThread(Person person) {
        this.person = person;
    }

    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + "prints " + person);
        }
    }
}
