package me.siyoon.sample.p148;

import io.reactivex.Flowable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class P148 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .concatMapEager(data -> Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS)
                        // concatMapEager가 반환하는 Flowable이 진짜 각각 다른쓰레드에서 실행되는지 확인해보기 위해서 doOnNext로 찍어봄
                        .doOnNext(opData -> System.out.println("(doOnNext) " + Thread.currentThread().getName() + ": " + opData))
                );

        flowable.subscribe(data -> {
            String threadName = Thread.currentThread().getName();
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
            System.out.println(threadName + ": data=" + data + ", time=" + time);
        });

        Thread.sleep(2000L);
    }
}
