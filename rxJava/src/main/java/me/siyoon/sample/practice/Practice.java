package me.siyoon.sample.practice;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(100L, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.computation())
                .doOnNext(data -> System.out.println("(doOnNext) " + Thread.currentThread().getName() + ": " + data))
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("(onNext)   " + Thread.currentThread().getName() + ": " + aLong);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(500L);
    }
}
