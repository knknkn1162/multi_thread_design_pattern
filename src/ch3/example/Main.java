package ch3.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        new ClientThread(requestQueue, "Alice", 314L).start();
        new ServerThread(requestQueue, "Bobby", 645L).start();
    }
}
