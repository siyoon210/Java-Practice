package me.siyoon.sample.p148;

import io.reactivex.Flowable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * [테스트 결과 정리]
 * 연산자를 사용하면 just라도 Computation 쓰레드에서 실행된다.
 * (그렇게되면 소비자도 생산자와 같은 Computation 쓰레드에서 실행된다.)
 */
public class P148 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .concatMapEager(data -> Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS)
                        // concatMapEager가 반환하는 Flowable이 진짜 각각 다른쓰레드에서 실행되는지 확인해보기 위해서 doOnNext로 찍어봄
                        .doOnNext(opData -> System.out.println("(doOnNext1) " + Thread.currentThread().getName() + ": " + opData))
                )
                .doOnNext(data -> System.out.println("(doOnNext2) " + Thread.currentThread().getName() + ": " + data));

        flowable.subscribe(data -> {
            String threadName = Thread.currentThread().getName();
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
            System.out.println(threadName + ": data=" + data + ", time=" + time);
        });

        Thread.sleep(2000L);
    }
}
