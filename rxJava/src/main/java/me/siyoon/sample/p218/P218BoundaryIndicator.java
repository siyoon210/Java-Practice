package me.siyoon.sample.p218;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P218BoundaryIndicator {
    public static void main(String[] args) throws InterruptedException {
        Flowable<List<Long>> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(7)
                .buffer(Flowable.interval(600L, TimeUnit.MILLISECONDS));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
