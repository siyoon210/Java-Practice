package me.siyoon.sample.p251;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P251 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .skipUntil(Flowable.timer(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(2000L);
    }
}
