package ch2;

/**
 * Created by kenta_nakajima on 2017/09/09.
 */
public class UserThread extends Thread{
    private final Gate gate;
    private final String myName;
    private final String myAddress;
    private final int count;

    public UserThread(Gate gate, String myName, String myAddress, int count) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
        this.count = count;
    }

    public void run() {
        System.out.println(myName + " BEGIN");
        for(int i = 0; i < count; i++) {
            gate.pass(myName, myAddress);
        }
    }

}
