package fastcampus3.javaexam.src.main.java.my.examples.javaexam.lottomachine;

import java.util.ArrayList;
import java.util.List;

public class LottoExam {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        //공 45개 생성
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoBalls.add(new LottoBall(i));
        }

        //머신에다가 공넣기
        lottoMachine.setLottoBalls(lottoBalls);

        //공섞기
        lottoMachine.mix();

        //공 6개 뽑기 (출력)
        lottoMachine.getLottoBalls().forEach(i-> System.out.print(i.getNumber()+"\t"));
    }
}
