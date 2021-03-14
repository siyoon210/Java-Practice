package practice.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncPractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncPractice asyncPractice = new AsyncPractice();
        String name = "siyoon";
        CompletableFuture<String> appendHello = asyncPractice.appendHello(name);
        System.out.println("appendHello 시작");
        CompletableFuture<String> appendBye = asyncPractice.appendBye(name);
        System.out.println("appendBye 시작");

        CompletableFuture.allOf(appendHello, appendBye).join();
        //이건 하는게 뭐지? -> join을 걸어서 위에 까지 연산에서 블로킹을 걸어버린다. 만약 allOf.join이 없으면 밑에 sout이 먼저 실행된다!
        System.out.println("아하!");
        System.out.println(appendHello.get() + appendBye.get());
    }

    private CompletableFuture<String> appendHello(String value) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello 끝!");
                return "Hello" + value;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return "ERROR";
            }
        });
    }

    private CompletableFuture<String> appendBye(String value) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Bye 끝!");
                return "Bye" + value;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return "ERROR";
            }
        });
    }
}
