package ch12.activeobject;

/**
 * Created by knknkn on 2017/09/21.
 */
class RealResult<T> extends Result<T> {
    private final T resultValue;

    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    public T getResultValue() {
        return resultValue;
    }
}
