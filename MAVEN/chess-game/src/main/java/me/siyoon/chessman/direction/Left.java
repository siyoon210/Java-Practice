package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Left implements MovableDirection {
    private final static Left instance = new Left();
    private final static Left instanceMaxDistanceOne = new Left(1);
    private final int maxDistance;

    private Left() {
        maxDistance = Board.WIDTH - 1;
    }

    private Left(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public static Left getInstance() {
        return instance;
    }

    public static Left getInstance(final int maxDistance) {
        if (maxDistance == 1) {
            return instanceMaxDistanceOne;
        }

        throw new RuntimeException("Left의 최대 거리는 1 혹은 제한 없음만 가능합니다.");
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return gapI == 0 && (gapJ >= 1 && gapJ <= maxDistance);
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int j = from.getIndexJ() - 1; j > to.getIndexJ(); j--) {
            if (Board.getChessmenByIndex(from.getIndexI(), j) != null) return true;
        }

        return false;
    }
}
