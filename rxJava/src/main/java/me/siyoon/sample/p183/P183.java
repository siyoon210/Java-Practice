package me.siyoon.sample.p183;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

public class P183 {
    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.fromCallable(() -> System.currentTimeMillis());

        flowable.subscribe(new DebugSubscriber<>());
    }
}
