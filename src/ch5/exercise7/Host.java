package ch5.exercise7;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */
public class Host {
    public static void execute(int count) throws InterruptedException {
        for(int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
                System.out.println("thread.interrupted");
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }

    //cannot be canceled!
    private static void doHeavyJob() {
        System.out.println("doHeavyJob begin");
        long start = System.currentTimeMillis();

        while(start+10000>System.currentTimeMillis()) {
            int s = 0;
            s = (s+1)%10;
        }
        System.out.println("doHeavyJob end");
    }
}
