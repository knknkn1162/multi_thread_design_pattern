package ch8.example;

/**
 * Created by knknkn on 2017/09/16.
 */
public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    // execute
    public void run() {
        while(true) {
            channel.takeRequest().execute();
        }
    }

}
