package me.siyoon.sample.p179;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

public class P179 {
    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E");

        flowable.subscribe(new DebugSubscriber<>());
    }
}
