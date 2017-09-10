package ch5.example;

/**
 * Created by knknkn on 2017/09/10.
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 31416).start();
        new MakerThread("MakerThread-3", table, 31417).start();
        new EaterThread("EaterThread-1", table, 31418).start();
        new EaterThread("EaterThread-2", table, 31419).start();
        new EaterThread("EaterThread-3", table, 31420).start();
    }
}
