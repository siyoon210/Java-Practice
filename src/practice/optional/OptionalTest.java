package practice.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    public static void main(String[] args) {
//        String str = null;
//        System.out.println(str.length());

//        String str = null;
//        if(str == null){
//            System.out.println(0);
//        }
//        else {
//            System.out.println(str.length());
//        }
        String str = null;
        Optional<String> strOptional = Optional.ofNullable(str);
        System.out.println(strOptional.orElse("").length());

        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "기본값";
            }
        };

        Supplier<Exception> exceptionSupplier = new Supplier<Exception>() {
            @Override
            public Exception get() {
                return new Exception();
            }
        };
    }
}
