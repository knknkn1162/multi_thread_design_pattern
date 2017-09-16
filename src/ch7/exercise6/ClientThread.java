package ch7.exercise6;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
import java.io.IOException;
import java.net.Socket;


public class ClientThread extends Thread {
    private final Socket clientSocket;
    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            Service.service(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
