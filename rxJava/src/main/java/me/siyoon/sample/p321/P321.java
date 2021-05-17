package me.siyoon.sample.p321;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class P321 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable = Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            try {
                Thread.sleep(1200L);
            } catch (InterruptedException e) {
                emitter.onError(e);
                return;
            }
            emitter.onNext(3);
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .timeout(1000L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
