package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Down implements MovableDirection {
    private final static Down instance = new Down();
    private final static Down instanceMaxDistanceOne = new Down(1);
    private final static Down instanceMaxDistanceTwo = new Down(2);
    private final int maxDistance;


    private Down() {
        maxDistance = Board.HEIGHT - 1;
    }
    private Down(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public static Down getInstance() {
        return instance;
    }

    public static Down getInstance(final int maxDistance) {
        if (maxDistance == 1) {
            return instanceMaxDistanceOne;
        } else if (maxDistance == 2) {
            return instanceMaxDistanceTwo;
        }

        throw new RuntimeException("Down의 최대 거리는 1,2 혹은 제한 없음만 가능합니다.");
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= -maxDistance && gapI <= -1) && gapJ == 0;
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int i = from.getIndexI() + 1; i < to.getIndexI(); i++) {
            if (Board.getChessmenByIndex(i, from.getIndexJ()) != null) return true;
        }

        return false;
    }
}
