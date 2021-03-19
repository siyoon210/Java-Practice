package practice.async;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AsyncList {
    enum Type {
        TYPE1, TYPE2, TYPE3
    }

    public static void main(String[] args) {
        EnumSet<Type> enumSet = EnumSet.allOf(Type.class);
        MyClass myClass = new MyClass();
        String result = myClass.test(enumSet);
        System.out.println("result = " + result);
    }

    static class MyClass {
        public String test(EnumSet<Type> enumSet) {
            List<CompletableFuture<Optional<String>>> futures = enumSet.stream()
                    .map(this::typeToCompletableFuture)
                    .collect(Collectors.toList());

            List<String> collect = futures.stream()
                    .map(CompletableFuture::join)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            for (String s : collect) {
                System.out.println("s = " + s);
            }

            return String.join("", collect);
        }

        private CompletableFuture<Optional<String>> typeToCompletableFuture(Type type) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println(type.toString() + " 시작");
                    Thread.sleep(2000);
                    return Optional.of(type.toString() + ": SUCCESS!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return Optional.empty();
                }
            });
        }
    }
}
