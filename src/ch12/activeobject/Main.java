package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("alice", activeObject).start();
        new MakerClientThread("bobby", activeObject).start();

        new DisplayClientThread("chris", activeObject).start();
    }
}
