package ch12.activeobject;

import com.sun.corba.se.spi.activation.ActivatorOperations;

/**
 * Created by knknkn on 2017/09/21.
 */
class Servant implements ActiveObject {
    public Result<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++) {
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }

        return new RealResult<String>(new String(buffer));
    }


    public void displayString(String string) {
        try {
            System.out.println("displayString; " + string);
            Thread.sleep(10);
        } catch (InterruptedException e) {}
    }
}
