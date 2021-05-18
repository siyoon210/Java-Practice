package me.siyoon.sample.p325;

import io.reactivex.processors.PublishProcessor;
import me.siyoon.sample.etc.DebugSubscriber;

public class P325 {
    public static void main(String[] args) {
        PublishProcessor<Integer> processor = PublishProcessor.create();

        processor.subscribe(new DebugSubscriber<>());

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);
    }
}
