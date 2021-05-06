package me.siyoon.sample.practice;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import me.siyoon.sample.etc.DebugSubscriber;

public class P206Test {
    public static void main(String[] args) {
        Flowable<Integer> original = Flowable.just(1, 2, 0, 4, 5)
                .map(data -> 10 / data);

        Flowable<Integer> flowable = original.flatMap(
                //computation을 넣어도 쓰레드가 안바뀌네?
                data -> Flowable.just(data).observeOn(Schedulers.computation()),
                error -> Flowable.just(-1),
                () -> Flowable.just(100)
        );

        flowable.subscribe(new DebugSubscriber<>());
    }
}
