package me.siyoon.sample.practice;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import me.siyoon.sample.etc.DebugSubscriber;

/**
 * 연산자에서는 Flowable이 새로 생성되기에 서로간의 Thread에 영향이 없다.
 * 다만 just, interval인 경우에 시간이 지남에 따라 just의 쓰레드에도 영향을 줌..
 */
public class P209Test {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just(1, 2, 3, 4, 5)
                .doOnNext(data -> System.out.println(Thread.currentThread().getName() + ":  " + data))
//                .subscribeOn(Schedulers.newThread())
                .concatMap(
                        sourceData -> Flowable.just("a", "b", "c")
                                .subscribeOn(Schedulers.computation())
                                .map(data -> {
                                    long time = System.currentTimeMillis();
                                    return time + "ms: [" + sourceData + "] " + data;
                                })
                );

        flowable.subscribe(new DebugSubscriber<>());
        Thread.sleep(5000L);
    }
}
