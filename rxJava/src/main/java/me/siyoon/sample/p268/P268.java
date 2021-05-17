package me.siyoon.sample.p268;

import io.reactivex.Flowable;
import me.siyoon.sample.etc.DebugSubscriber;

import java.util.Arrays;

public class P268 {
    public static void main(String[] args) {
        Flowable<Integer> flowable1 = Flowable.just(1, 2, 3, 4);
        Flowable<Integer> flowable2 = Flowable.just(5, 6, 7, 8);
        Flowable<Integer> flowable3 = Flowable.just(9, 10, 11, 12);
        Flowable<Integer> flowable4 = Flowable.just(13, 14, 15, 16);
        Flowable<Integer> flowable5 = Flowable.just(17, 18, 19, 20);

        //Iterable을 받으니까 4개 이상 담을수 있을지 테스트 => 담을 수 있다.
        Flowable<Integer> merge = Flowable.merge(Arrays.asList(flowable1, flowable2, flowable3, flowable4, flowable5));

        merge.subscribe(new DebugSubscriber<>());
    }
}
