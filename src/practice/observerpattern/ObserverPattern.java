package practice.observerpattern;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new MyStringSubject();
        Observer observer1 = new MyStringObserver("1");
        Observer observer2 = new MyStringObserver("2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.notifyObservers("안녕~~");

        subject.unregisterObserver(observer1);

        subject.notifyObservers("잘가~~");
    }
}

interface Observer<T> {
    void observe(T event);
}


class MyStringObserver implements Observer<String> {
    private final String label;

    public MyStringObserver(String label) {
        this.label = label;
    }

    @Override
    public void observe(String event) {
        System.out.println("My String Obeserver " + label + " : " + event);
    }
}

interface Subject<T> {
    void registerObserver(Observer<T> observer);

    void unregisterObserver(Observer<T> observer);

    void notifyObservers(T event);
}

class MyStringSubject implements Subject<String> {
    //Subject가 notify해야할 옵저버들을 가지고 있는 것이 핵심!
    private final Set<Observer<String>> observers = new CopyOnWriteArraySet<>();

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        observers.stream().forEach(observer -> {
            observer.observe(event);
        });
    }
}



