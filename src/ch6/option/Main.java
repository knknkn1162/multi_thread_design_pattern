package ch6.option;

/**
 * Created by knknkn on 2017/09/11.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        for (int i =0; i <20; i++) {
            new ReaderThread(data).start();
        }
        String chs = "abcdefghi";
        for (int j = 0; j < 2; j++) {
           new WriterThread(data, chs).start();
        }
    }
}
