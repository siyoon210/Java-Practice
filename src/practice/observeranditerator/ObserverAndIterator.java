package practice.observeranditerator;

/*
 * 리액티브 스트림은 옵저버 패턴과 이터레이터 패턴의 조화다!!
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverAndIterator {
    public static void main(String[] args) {
        Observable<String> observable = new MyStringObservable();
        RxObserver<String> rxObserver1 = new MyStringRxObserver("1");
        RxObserver<String> rxObserver2 = new MyStringRxObserver("2");

        observable.subscribe(rxObserver1);
        observable.subscribe(rxObserver2);

        List<String> strings = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = strings.iterator();

        // 음.. 뭔가 이런 로직이 Observable쪽에 잇어야 할것같다. 한번 RxJava를 보는것도 좋을듯!!
        while (iterator.hasNext()) {
            observable.next(iterator.next());
        }
        observable.complete();
    }
}

interface RxObserver<T> {
    void onNext(T event); //옵저버 패턴 Observer의 observe() 메서드 역할

    void onComplete(); //이터레이터 패턴 hasNext() 처럼 마지막을 알게되었을때 수행되는 메서드
}

class MyStringRxObserver implements RxObserver<String> {
    private final String label;

    public MyStringRxObserver(String label) {
        this.label = label;
    }

    @Override
    public void onNext(String event) {
        System.out.println("My String Rx Observer" + label + " get event : " + event);
    }

    @Override
    public void onComplete() {
        System.out.println("My String Rx Observer" + label + " get complete");
    }
}

//옵저버 패턴의 Subject(주체)
interface Observable<T> {
    void subscribe(RxObserver<T> rxObserver); //옵저버 패턴 Subject의 registerObserver() 메서드 역할

    void unsubscribe(RxObserver<T> rxObserver); //옵저버 패턴 Subject의 unregisterObserver() 메서드 역할

    void next(T event); //옵저버 패턴 Subject의 notify() 메서드 역할

    void complete(); //이터레이터 패턴의 hasNext()처럼 옵저버들에게 완료를 알리는 역할
}

class MyStringObservable implements Observable<String> {
    private final Set<RxObserver<String>> rxObservers = new CopyOnWriteArraySet<>();

    @Override
    public void subscribe(RxObserver<String> rxObserver) {
        rxObservers.add(rxObserver);
    }

    @Override
    public void unsubscribe(RxObserver<String> rxObserver) {
        rxObservers.remove(rxObserver);
    }

    @Override
    public void next(String event) {
        rxObservers.stream().forEach(rxObserver -> {
            rxObserver.onNext(event);
        });
    }

    @Override
    public void complete() {
        rxObservers.stream().forEach(rxObserver -> {
            rxObserver.onComplete();
        });
    }
}
