package ch4.example;

import javafx.scene.control.TextFormatter;

/**
 * Created by knknkn on 2017/09/10.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
