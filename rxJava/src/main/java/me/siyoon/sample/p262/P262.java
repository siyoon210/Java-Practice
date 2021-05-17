package me.siyoon.sample.p262;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P262 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.create((FlowableOnSubscribe<String>)emitter -> {
            emitter.onNext("A");
            Thread.sleep(1000L);

            emitter.onNext("B");
            Thread.sleep(300L);

            emitter.onNext("C");
            Thread.sleep(300L);

            emitter.onNext("D");
            Thread.sleep(1000L);

            emitter.onNext("E");
            Thread.sleep(100L);

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
//                .doOnNext(data -> System.out.println(Thread.currentThread().getName() + ": " + data))
                .throttleWithTimeout(500L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3500L);
    }
}
