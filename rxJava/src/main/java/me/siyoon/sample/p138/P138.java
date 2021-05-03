package me.siyoon.sample.p138;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class P138 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 기본 전제 : 연산자, 소비자의 실행쓰레드는 기본적으로 생산자의 쓰레드를 따라서 같이 쓴다!
         * 1. just는 본래 main Thread에서 실행된다.
         * 2. subscribeOn으로 생산자의 쓰레드를 바꾸었다.
         * 3. 소비자의 쓰레드도 생산자의 쓰레드를 따라서 같이 쓰기 때문에 main이 아닌 RxComputationThread를 사용한다!
        */
        Flowable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .subscribe(data -> System.out.println(Thread.currentThread().getName() + ": " + data));

        Thread.sleep(500);
    }
}
