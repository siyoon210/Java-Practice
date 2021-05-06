package me.siyoon.sample.p201;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

public class P201 {
    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "", "B", "", "C")
                .flatMap(data -> {
                    if (data.equals("")) {
                        return Flowable.empty();
                    }

                    return Flowable.just(data.toLowerCase());
                });

        flowable.subscribe(new DebugSubscriber<>());
    }
}
