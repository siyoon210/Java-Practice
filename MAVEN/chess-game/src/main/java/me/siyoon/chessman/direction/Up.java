package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Up implements Direction {
    private final static Up instance = new Up();
    private final static Up instanceMaxDistanceOne = new Up(1);
    private final static Up instanceMaxDistanceTwo = new Up(2);
    private final int maxDistance;

    private Up() {
        maxDistance = Board.HEIGHT - 1;
    }

    private Up(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public static Up getInstance() {
        return instance;
    }

    public static Up getInstance(final int maxDistance) {
        if (maxDistance == 1) {
            return instanceMaxDistanceOne;
        } else if (maxDistance == 2) {
            return instanceMaxDistanceTwo;
        }

        throw new RuntimeException("Up의 최대 거리는 1,2 혹은 제한 없음만 가능합니다.");
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= 1 && gapI <= maxDistance) && gapJ == 0;
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int i = from.getIndexI() - 1; i > to.getIndexI(); i--) {
            if (Board.getChessmenByIndex(i, from.getIndexJ()) != null) return true;
        }

        return false;
    }
}
