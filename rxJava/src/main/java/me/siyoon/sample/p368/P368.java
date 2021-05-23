package me.siyoon.sample.p368;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.TestSubscriber;
import me.siyoon.sample.etc.DebugSubscriber;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

public class P368 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS).take(5);

        class Counter {
            private int count;

            void increment() {
                count++;
            }

            int get() {
                return count;
            }
        }

        Counter counter = new Counter();

        flowable.blockingSubscribe(new DisposableSubscriber<Long>() {
            @Override
            public void onNext(Long aLong) {
                counter.increment();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        System.out.println("counter.get() = " + counter.get());
        Assertions.assertEquals(counter.get(), 5L);
    }
}
