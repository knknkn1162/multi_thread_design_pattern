package ch7.option2.ThreadClass;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class Helper {
    public void handle(int count, char c) {
        System.out.println(" handle(" + count + ", " + c + ") begin");

        for(int i = 0 ; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println("");
        System.out.println(" handle(" + count + "," + c + ") end");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }
}
