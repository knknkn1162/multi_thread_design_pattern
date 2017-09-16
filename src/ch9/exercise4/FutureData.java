package ch9.exercise4;

/**
 * Created by knknkn on 2017/09/16.
 */
public class FutureData implements Data {
    private RealData realdata = null;
    private boolean ready = false;

    public synchronized void setRealdata(RealData realdata) {
        if (ready) { return;}
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        if (realdata == null) {
            return null; //balk
        }
        while(ready) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        return realdata.getContent();
    }


}
