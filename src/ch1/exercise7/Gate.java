package ch1.exercise7;

/**
 * Created by kenta_nakajima on 2017/09/18.
 */
public class Gate {
    private int counter = 0;
    private String name = "NoBody";

    private String address = "NoWhere";

    private final Mutex mutex = new Mutex();

    public void pass(String name, String address) {
        mutex.lock();
        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            mutex.unlock();
        }
    }

    public String toString() {
        String s = null;
        mutex.lock();

        try {
            s = "No. " + counter + " : " + name + ", " + address;
        } finally {
            mutex.unlock();
        }

        return s;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("*** broken ***" + toString());
        }
    }

}
