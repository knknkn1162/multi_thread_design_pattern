package ch2;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate");
        Gate gate = new Gate();
        String[][] info = {
                {"Alice", "Alaska"},
                {"Bobby", "Brazil"},
                {"Chris", "Canada"},
        };
        for (String[] s: info) {
            new UserThread(gate, s[0], s[1]).start();
        }
    }
}
