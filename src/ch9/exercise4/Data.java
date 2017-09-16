package ch9.exercise4;

import java.util.concurrent.ExecutionException;

/**
 * Created by knknkn on 2017/09/16.
 */

import java.util.concurrent.ExecutionException;

public interface Data {
    public abstract String getContent() throws ExecutionException;
}
