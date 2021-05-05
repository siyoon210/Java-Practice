package me.siyoon.sample.practice;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * [테스트 결과 정리]
 * 연산자를 사용하면 just라도 Computation 쓰레드에서 실행된다. (X) -> delay를 거니까 Computaion 쓰레드에서 실행된다.
 * (그렇게되면 소비자도 생산자와 같은 Computation 쓰레드에서 실행된다.)
 *
 * 연산자안의 Flowable의 observeOn을 명시하면 연산자 밖의 Flowable 쓰레드가 바뀐다.
 * 그러면 연산자안의 Flowable이 밖의 Flowable의 생산자가 되는건가?
 * 연산자안 -> 연산자밖 -> 연산자밖 소비자
 */
public class OperatorPractice {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .subscribeOn(Schedulers.newThread())
                .concatMapEager(data -> Flowable.just(data)
//                        .delay(100L, TimeUnit.MILLISECONDS)
//                        .subscribeOn(Schedulers.computation())
                                // concatMapEager가 반환하는 Flowable이 진짜 각각 다른쓰레드에서 실행되는지 확인해보기 위해서 doOnNext로 찍어봄
                                .doOnNext(opData -> System.out.println("(doOnNext1) " + Thread.currentThread().getName() + ": " + opData))
//                        .observeOn(Schedulers.newThread())
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
