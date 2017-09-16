package ch9.exercise4;

/**
 * Created by knknkn on 2017/09/16.
 */
public class Host {
    public Data request(final int count, final char ch) {
        System.out.println(" request(" + count + ", " + ch + ") begin");

        final FutureData future = new FutureData();

        new Thread() {
            public void run() {
                try {
                    RealData realData = new RealData(count, ch);
                    future.setRealdata(realData);
                } catch (Exception e) {
                    future.setException(e);
                }
            }
        }.start();

        System.out.println("request(" + count + ", " + ch + ") END");

        return future;
    }

}
