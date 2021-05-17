package me.siyoon.sample.p307;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P307 {
    public static void main(String[] args) throws InterruptedException {
        final long startTime = System.currentTimeMillis();
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .take(3)
                .repeatUntil(() -> {
                    System.out.println("Called");
                    boolean b = System.currentTimeMillis() - startTime > 500L;
                    System.out.println(b);
                    return b;
                });

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(1000L);

    }
}
