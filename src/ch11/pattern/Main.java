package ch11.pattern;

/**
 * Created by knknkn on 2017/09/19.
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("bobby").start();
        new ClientThread("chris").start();
    }
}
