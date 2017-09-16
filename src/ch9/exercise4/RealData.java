package ch9.exercise4;

/**
 * Created by knknkn on 2017/09/16.
 */
public class RealData implements Data {
    private final String content;
    public RealData(int count, char ch) {
        System.out.println("maken RealData(" + count + ", " + ch + ") begin");

        char[] buffer = new char[count];

        for(int i = 0; i < count; i++) {
            buffer[i] = ch;
            try { Thread.sleep(100);} catch (InterruptedException e) {}
        }

        System.out.println("making RealData(" + count + ", " + ch + ") end");
        this.content = new String(buffer);
     }

     public String getContent() {
        return content;
     }
}
