package me.siyoon.sample.p213;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P213 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(10, 3)
                .concatMapEagerDelayError(
                        sourceData -> Flowable.interval(1000L, TimeUnit.MILLISECONDS).take(3)
                        .doOnNext(data -> {
                            if (sourceData == 11 && data == 1) {
                                throw new RuntimeException("예외 발생");
                            }
                        })
                        .map(data -> "[" + sourceData + "] " + data),
                        false
                );

        flowable.subscribe(new DebugSubscriber<>());
        Thread.sleep(10000L);
    }
}
