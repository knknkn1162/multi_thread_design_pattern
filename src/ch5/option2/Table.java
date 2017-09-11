package ch5.option2;

/**
 * Created by kenta_nakajima on 2017/09/11.
 */

import java.util.concurrent.ArrayBlockingQueue;

public class Table extends ArrayBlockingQueue<String>{
    public Table(int count) {
        super(count);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

}
