package ch7.option2.RunnableExample;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */
public class Host {
    private final Helper helper = new Helper();
    public void request(final int count, final char ch) {
        System.out.println("request( " + count + ", " + ch + ") begin");

        new Thread(
                new Runnable() {
                    public void run() {
                        helper.handle(count, ch);
                    }
                }
        ).start();

        System.out.println("request(" + count + ", " + ch + ") end");
    }
}
