package fastcampus.lottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {
    public static void main(String[] args){
        List<LottoBall> balls = LottoBallFactory.createBalls(45);

        LottoMachine lm = new LottoMachine(balls);


        for (int j=0; j<5; j++) {
            //공섞기
            lm.shuffleBalls();

            //공뽑기
            List<LottoBall> selectedBalls = new ArrayList<LottoBall>();
            selectedBalls.addAll(lm.getBallList(6));
            for (int i = 0; i < selectedBalls.size(); i++) {
                System.out.print(selectedBalls.get(i).getNumber() + " ");
            }
            System.out.println(" ");
        }

    }
}
