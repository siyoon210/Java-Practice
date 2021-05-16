package me.siyoon.sample.p312;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P312 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println(data))
                .take(3)
                .repeatWhen(completeHandler -> {
                    return completeHandler
                            .delay(1000L, TimeUnit.MILLISECONDS)
                            .take(2)
                            .doOnNext(data -> System.out.println("emit: " + data))
                            .doOnComplete(() -> System.out.println("comptle"));
                })
                .map(data -> System.currentTimeMillis() + "ms: " + data);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(5000L);
    }
}
