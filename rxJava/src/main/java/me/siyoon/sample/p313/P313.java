package me.siyoon.sample.p313;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P313 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("처리 시작 : " + System.currentTimeMillis() );

        Flowable<String> flowable = Flowable.create((FlowableOnSubscribe<String>) emitter -> {
            System.out.println("구독 시작 : " + System.currentTimeMillis());
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .delay(2000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("통지 시각 : " + System.currentTimeMillis()));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
