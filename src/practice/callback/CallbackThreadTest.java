package practice.callback;

class Service {
    void process(Runnable runnable) {
        System.out.println("서비스 실행 쓰레드 " + Thread.currentThread().getName());
        new Thread(() ->{
            runnable.run();
        }).start();
    }
}

public class CallbackThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        System.out.println("메인 시작! 쓰레드 " + Thread.currentThread().getName());
        Runnable runnable = () -> {
            System.out.println("콜백 쓰레드 " + Thread.currentThread().getName());
        };
        service.process(runnable);
        System.out.println("메인 끝! 쓰레드 " + Thread.currentThread().getName());
        Thread.sleep(1000L);
    }
}
