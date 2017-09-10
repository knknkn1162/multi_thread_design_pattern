package ch1.exercise6;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class EaterThread extends Thread{
    private String name;
    private final Tool lefthand;
    private final Tool righthand;

    public EaterThread(String name, Tool lefthand, Tool righthand) {
        this.name = name;
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public void run() {
        while(true) {
            eat();
        }
    }

    public synchronized void eat() {
        System.out.println(name + "takes up " + lefthand + " (left).");
        System.out.println(name + " takes up " + righthand + " (right).");
        System.out.println(name + " is eating now, yum yum!");
        System.out.println(name + " puts down " + righthand + "  (right).");
        System.out.println(name + " puts down " + lefthand + " (left).");
    }

}
