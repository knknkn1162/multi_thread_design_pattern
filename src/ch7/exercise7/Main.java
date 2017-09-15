package ch7.exercise7;

import java.io.IOException;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */
public class Main {
    public static void main(String args[]) {
        try {
            new MiniServer(8888).execute();
        } catch (IOException e) {}
    }
}
