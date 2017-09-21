package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
class MakeStringRequest extends MethodRequest<String> {
    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
        super(servant, future);
        this.count = count;
        this.fillchar = fillchar;
    }

    public void execute() {
        Result<String> result = servant.makeString(count, fillchar);
        future.setResult(result);
    }
}
