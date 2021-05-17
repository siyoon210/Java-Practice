package me.siyoon.sample.p279;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P279 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS).take(5)
                .doOnNext(data -> System.out.println("Flowable " + data +" : " +Thread.currentThread().getName()));

        Flowable<Long> other = Flowable.interval(500L, TimeUnit.MILLISECONDS).take(2)
                .doOnNext(data -> System.out.println("other " + data +" : " +Thread.currentThread().getName()));

        Flowable<Long> result = flowable.startWith(other);

        result.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
