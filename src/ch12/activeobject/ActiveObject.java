package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);
    public abstract void displayString(String string);
}
