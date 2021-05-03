package me.siyoon.sample.p141;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class P141 {
    public static void main(String[] args) throws InterruptedException {
        Flowable flowable =
                Flowable.interval(300L, TimeUnit.MILLISECONDS)
                        .onBackpressureDrop();

        flowable
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long item) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }

                        System.out.println(Thread.currentThread().getName() + ": " + item);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(7000L);
    }
}
