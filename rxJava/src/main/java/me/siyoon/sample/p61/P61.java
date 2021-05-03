package me.siyoon.sample.p61;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class P61 {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(200L, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<Long>() {

                    private Subscription subscription;
                    private long startTime;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.startTime = System.currentTimeMillis();
                        this.subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        if (System.currentTimeMillis() - startTime > 500) {
                            subscription.cancel();
                            System.out.println("구독 해지");
                            return;
                        }

                        System.out.println("data=" + aLong);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(2000L);
    }
}
