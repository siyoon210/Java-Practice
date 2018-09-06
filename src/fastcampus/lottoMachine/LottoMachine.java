package fastcampus.lottoMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private List<LottoBall> ballList;

    public LottoMachine(List<LottoBall> ballList) {
        this.ballList = ballList;
    }

    //공을 뽑는다.
    public List<LottoBall> getBallList(int numberOfBalls) {
        List<LottoBall> selectedBalls = new ArrayList<LottoBall>();
        for (int i=0; i<numberOfBalls; i++){
            selectedBalls.add(ballList.get(i));
        }
        return selectedBalls;
    }

    public void setBallList(List<LottoBall> ballList) {
        this.ballList = ballList;
    }

    //공을 섞는다.
    public void shuffleBalls(){
        Collections.shuffle(ballList);
    }

}
