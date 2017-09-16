package ch7.exercise7;

/**
 * Created by kenta_nakajima on 2017/09/16.
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("BEGIN");
        Object obj = new Object();

        Blackhole.enter(obj);

        System.out.println("END");
    }
}
