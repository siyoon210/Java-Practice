package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class UpRight implements Direction {
    private final static UpRight instance = new UpRight();
    private final static UpRight instanceMaxDistanceOne = new UpRight(1);
    private final int maxDistance;

    private UpRight() {
        maxDistance = Board.HEIGHT - 1;
    }

    private UpRight(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public static UpRight getInstance() {
        return instance;
    }

    public static UpRight getInstance(final int maxDistance) {
        if (maxDistance == 1) {
            return instanceMaxDistanceOne;
        }

        throw new RuntimeException("UpLeft의 최대 거리는 1 혹은 제한 없음만 가능합니다.");
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= 1 && gapI <= maxDistance) && (gapJ >= -maxDistance && gapJ <= -1) && (Math.abs(gapI) == Math.abs(gapJ));
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int i = from.getIndexI() - 1; i > to.getIndexI(); i--) {
            final int j = from.getIndexJ() + (Math.abs(from.getIndexI() - i));
            if (Board.getChessmenByIndex(i, j) != null) return true;
        }

        return false;
    }
}
