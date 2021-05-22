package me.siyoon.sample.p366;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class P366Practice {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("시작시간 = " + System.currentTimeMillis());
        Iterable<Long> result = Flowable.interval(2000L, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingIterable();

        Iterator<Long> iterator = result.iterator();

        while (iterator.hasNext()) {
            System.out.println("hasNext : " + System.currentTimeMillis());
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
    }
}
