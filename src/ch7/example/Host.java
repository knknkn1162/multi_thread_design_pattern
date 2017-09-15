package ch7.example;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class Host {
    private final Helper helper = new Helper();
    public void request(final int count, final char c) {
        System.out.println("request(" + count + ", " + c + ") begin");

        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();

        System.out.println("request(" + count + ", " + c + ") end");
    }
}
