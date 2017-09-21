package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
public class DisplayStringRequest extends MethodRequest<Object> {
    private final String string;
    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }

    public void execute() {
        servant.displayString(string);
    }
}
