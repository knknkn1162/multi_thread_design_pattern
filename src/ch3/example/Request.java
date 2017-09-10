package ch3.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */
public class Request {
    private final String name;
    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "[ Request " + name + "]";
    }
}
