package ch4.exercise5;

/**
 * Created by knknkn on 2017/09/10.
 */
public class Main {
    public static void main(String[] args) {
        for(int i = 0; i <100; i++) {
            new TestThread().start();
        }
    }
}
