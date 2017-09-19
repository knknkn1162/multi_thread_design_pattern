package ch11.pattern;

/**
 * Created by knknkn on 2017/09/19.
 */
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSLog {
    private PrintWriter writer = null;

    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.println("--end of log---");
        writer.close();
    }
}
