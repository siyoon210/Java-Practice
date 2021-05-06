package me.siyoon.sample.p203;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P203 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(1, 3)
                .flatMap(data -> Flowable.interval(100L, TimeUnit.MILLISECONDS).take(3),
                        (sourceData, newData) -> "[" + sourceData + "]" + newData);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(1000L);
    }
}
