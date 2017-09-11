package ch5.exercise9;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Something.method(10000);
        } catch (InterruptedException e) {
            System.out.println("exception");
        }
    }
}
