package ch7.exercise7;

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

        try {
            while(true) {
                System.out.println("Accepting...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket);

                try {
                    Service.service(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
