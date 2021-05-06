package me.siyoon.sample.p206;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

public class P206 {
    public static void main(String[] args) {
        Flowable<Integer> original = Flowable.just(1, 2, 0, 4, 5)
                .map(data -> 10 / data);

        Flowable<Integer> flowable = original.flatMap(
                Flowable::just,
                error -> Flowable.just(-1),
                () -> Flowable.just(100)
        );

        flowable.subscribe(new DebugSubscriber<>());
    }
}
