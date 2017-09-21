package ch12.activeobject;

import java.net.ServerSocket;

/**
 * Created by knknkn on 2017/09/21.
 */
abstract class MethodRequest<T> {
    protected final Servant servant;
    protected final FutureResult<T> future;
    protected MethodRequest(Servant servant, FutureResult<T> future) {
        this.servant = servant;
        this.future = future;
    }

    public abstract void execute();
}
