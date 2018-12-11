package fastcampus3.javaexam.src.main.java.my.examples.javaexam.lottomachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private List<LottoBall> lottoBalls;

    public void mix() {
        Collections.shuffle(lottoBalls);
    }
    public List<LottoBall> getLottoBalls() {
        List<LottoBall> selectedBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            selectedBalls.add(lottoBalls.get(i));
        }
        return selectedBalls;
    }

    public void setLottoBalls(List<LottoBall> lottoBalls) {
        this.lottoBalls = lottoBalls;
    }
}
