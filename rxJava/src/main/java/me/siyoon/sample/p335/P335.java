package me.siyoon.sample.p335;

import io.reactivex.processors.ReplayProcessor;
import me.siyoon.sample.etc.DebugSubscriber;

public class P335 {
    public static void main(String[] args) {
        ReplayProcessor<Integer> processor = ReplayProcessor.create();

        processor.subscribe(new DebugSubscriber<>("No. 1"));

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);

        System.out.println("Subscriber No.2 추가");
        processor.subscribe(new DebugSubscriber<>("No. 2"));

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete();

        System.out.println("Subscriber No.3 추가");
        processor.subscribe(new DebugSubscriber<>("No. 3"));
    }
}
