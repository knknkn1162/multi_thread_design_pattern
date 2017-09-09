package ch1.exercise6;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread");

        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");

        //occurs dead lock!!
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }
}
