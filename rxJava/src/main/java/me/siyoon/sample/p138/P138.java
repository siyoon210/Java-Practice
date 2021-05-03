package me.siyoon.sample.p138;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class P138 {
    public static void main(String[] args) throws InterruptedException {
        Flowable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .subscribe(data -> System.out.println(Thread.currentThread().getName() + ": " + data));

        Thread.sleep(500);
    }
}
