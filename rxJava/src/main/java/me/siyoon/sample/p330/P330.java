package me.siyoon.sample.p330;

import io.reactivex.processors.PublishProcessor;
import me.siyoon.sample.etc.DebugSubscriber;

public class P330 {
    public static void main(String[] args) {
        PublishProcessor<Integer> publishProcessor = PublishProcessor.create();

        System.out.println("Subscriber No. 1 추가");
        publishProcessor.subscribe(new DebugSubscriber<>("No. 1"));

        publishProcessor.onNext(1);
        publishProcessor.onNext(2);
        publishProcessor.onNext(3);

        System.out.println("Subscriber No. 2 추가");
        publishProcessor.subscribe(new DebugSubscriber<>("No. 2"));

        publishProcessor.onNext(4);
        publishProcessor.onNext(5);

        publishProcessor.onComplete();

        System.out.println("Subscriber No. 3 추가");
        publishProcessor.subscribe(new DebugSubscriber<>("No. 3"));
    }
}
