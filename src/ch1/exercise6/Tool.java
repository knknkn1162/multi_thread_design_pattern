package ch1.exercise6;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Tool {
    private final String name;
    public Tool(String name) {
        this.name = name;
    }

    public String toString() {
        return "[ " + name + "] ";
    }
}
