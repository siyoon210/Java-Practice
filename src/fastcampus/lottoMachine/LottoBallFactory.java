package fastcampus.lottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {

    private LottoBallFactory(){
        //로또공 공장이 여러개일 필요가 없다.
    }

    //공을 만든다.
    public static List<LottoBall> createBalls(int numberOfBalls){
        List<LottoBall> balls = new ArrayList<LottoBall>();
        for(int i = 1; i<=numberOfBalls; i++){
            LottoBall ball = new LottoBall(i);
            balls.add(ball);
        }

        return balls;
    }
}
