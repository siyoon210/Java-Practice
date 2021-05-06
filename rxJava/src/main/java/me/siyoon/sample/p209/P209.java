package me.siyoon.sample.p209;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P209 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(10, 3)
                .concatMap(
                        sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS).take(2)
                        .map(data -> {
                            long time = System.currentTimeMillis();
                            return time + "ms: [" + sourceData + "] " + data;
                        })
                );

        flowable.subscribe(new DebugSubscriber<>());
        Thread.sleep(4000L);
    }
}
