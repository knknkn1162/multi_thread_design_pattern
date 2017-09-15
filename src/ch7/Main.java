package ch7;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main begin");

        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'c');

        System.out.println("main END");
    }
}
