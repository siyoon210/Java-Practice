package me.siyoon.sample.p249;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P249 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .skip(2);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(500L);
    }
}
