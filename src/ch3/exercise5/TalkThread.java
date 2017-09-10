package ch3.exercise5;

/**
 * Created by knknkn on 2017/09/10.
 */
public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }


    public void run() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        for (int i = 0; i < 20; i++) {

            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }

        System.out.println(Thread.currentThread().getName() + ":END");
     }
}
