package me.siyoon.sample.p279;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P279Just {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.just(1L, 2L, 3L, 4L, 5L)
                .doOnNext(data -> System.out.println("Flowable " + data +" : " +Thread.currentThread().getName()));

        Flowable<Long> other = Flowable.just(1L, 2L)
                .doOnNext(data -> System.out.println("other " + data +" : " +Thread.currentThread().getName()));

        Flowable<Long> result = flowable.startWith(other);

        result.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
