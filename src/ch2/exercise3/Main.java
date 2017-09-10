package ch2.exercise3;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */

class NotSynch {
    private final String name = "NotSynch";
    public String toString() {
        return "[ " + name + "]";
    }
}

class Synch {
    private final String name = "Synch";
    public synchronized String toString() {
        return "[ " + name + "]";
    }
}

public class Main {
    private static final long CALL_COUNT = 100000000L;
    public static void main(String[] args) {
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + "BEGIN");
        long start_time = System.currentTimeMillis();

        for (long i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + "END");
        System.out.println(System.currentTimeMillis() - start_time + "msec.");
    }
}
