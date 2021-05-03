package me.siyoon.sample.p51;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class P51 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Exception {
                String[] datas = {"Hello, World!", "안녕, RxJava!"};
                for (String data : datas) {
                    if (emitter.isCancelled()) {
                        return;
                    }

                    emitter.onNext(data);
                }
                emitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(1L);
                    }

                    @Override
                    public void onNext(String data) {
                        //각기 다른 쓰레드에서 처리가 되는데 이때 쓰레드 이름을 출력하기 위함
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + data);
                        this.subscription.request(1L);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": 완료");
                    }
                });


        Thread.sleep(500L);
    }
}
