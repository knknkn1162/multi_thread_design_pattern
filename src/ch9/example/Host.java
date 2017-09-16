package ch9.example;

/**
 * Created by knknkn on 2017/09/16.
 */
public class Host {
    public Data request(final int count, final char ch) {
        System.out.println(" request(" + count + ", " + ch + ") begin");

        final FutureData future = new FutureData();

        new Thread() {
            public void run() {
                RealData realData = new RealData(count, ch);
                future.setRealdata(realData);
            }
        }.start();

        System.out.println("request(" + count + ", " + ch + ") END");

        return future;
    }

}
