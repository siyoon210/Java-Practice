package me.siyoon.sample.p276;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class P276 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable1 = Flowable.interval(300L, TimeUnit.MILLISECONDS).take(5)
                .doOnNext(data -> System.out.println(data + ": " + Thread.currentThread().getName()));
        Flowable<Long> flowable2 = Flowable.interval(300L, TimeUnit.MILLISECONDS).take(5).map(data -> data + 100L)
                .doOnNext(data -> System.out.println(data + ": " + Thread.currentThread().getName()));

        Flowable<Long> concatEager = Flowable.concatEager(Arrays.asList(flowable1, flowable2));

        concatEager.subscribe(new DebugSubscriber<>());

        Thread.sleep(6000L);
    }
}
