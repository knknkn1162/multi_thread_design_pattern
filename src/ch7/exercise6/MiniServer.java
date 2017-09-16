package ch7.exercise6;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class MiniServer {
    private final int portnumber;

    public MiniServer(int portnumber) {
        this.portnumber = portnumber;
    }

    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portnumber);
        System.out.println("Listening on " + serverSocket);
        System.out.println("Accepting...");
        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accept in " + clientSocket);
            new ClientThread(clientSocket).start();
        }
    }
}
