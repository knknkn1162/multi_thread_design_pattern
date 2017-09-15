package ch7.exercise4;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class HelperThread extends Thread{
    private final int count;
    private final char ch;
    private Helper helper;
    HelperThread(Helper helper, int count, char ch) {
        this.helper = helper;
        this.count = count;
        this.ch = ch;
    }

    public void run() {
        helper.handle(count, ch);
    }

}
