package me.siyoon.sample.p317;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P317 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("처리 시작 : " + System.currentTimeMillis() );

        Flowable<String> flowable = Flowable.create((FlowableOnSubscribe<String>) emitter -> {
                System.out.println("구독 시작 : " + System.currentTimeMillis());
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
                emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .delaySubscription(2000L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
