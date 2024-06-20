package ch.sbb.spc.demo;

import androidx.annotation.NonNull;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public class DefaultContinuation<T> implements Continuation<T> {
    DefaultContinuation(Func<T> callback) {
        this.callback = callback;
    }

    public interface Func<T> {
        void call(T result);
    }

    private final Func<T> callback;

    @Override
    public void resumeWith(@NonNull Object o) {
        //noinspection unchecked
        callback.call((T) o);
    }

    @NonNull
    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
