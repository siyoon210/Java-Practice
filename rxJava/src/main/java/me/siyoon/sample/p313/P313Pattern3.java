package me.siyoon.sample.p313;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P313Pattern3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("처리 시작 : " + System.currentTimeMillis());

        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .doOnSubscribe(data -> System.out.println("구독 시작 : " + System.currentTimeMillis()))
                .delay(Flowable.timer(1000L, TimeUnit.MILLISECONDS), delayData -> Flowable.timer(2000L, TimeUnit.MILLISECONDS))
                .doOnNext(data -> System.out.println("통지 시각 : " + System.currentTimeMillis() + ", data :" + data));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(5000L);
    }
}
