package me.siyoon.sample.p325;

import io.reactivex.Flowable;
import io.reactivex.processors.PublishProcessor;
import me.siyoon.sample.etc.DebugSubscriber;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class P325_Practice {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS).take(4);
        class MyProcessor implements Processor<Long, Long> {
            private Subscriber<? super Long> subscriber;

            @Override
            public void subscribe(Subscriber<? super Long> s) {
                subscriber = s;
            }

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Long aLong) {
                subscriber.onNext(aLong + 100L);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        }
        MyProcessor processor = new MyProcessor();
        flowable.subscribe(processor);
        processor.subscribe(new DebugSubscriber<>());
        Thread.sleep(2000L);
    }
}
