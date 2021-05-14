package me.siyoon.sample.p260;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P260 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(9)
                .sample(Flowable.interval(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
