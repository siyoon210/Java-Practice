package fastcampus3.javaexam.src.main.java.my.examples.javaexam.lottomachine;

import java.util.ArrayList;
import java.util.List;

public class KoreaLottoBallFactory implements LottoBallFactory {
    @Override
    public List<LottoBall> createLottoBall() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoBalls.add(new LottoBall(i));
        }
        return lottoBalls;
    }
}
