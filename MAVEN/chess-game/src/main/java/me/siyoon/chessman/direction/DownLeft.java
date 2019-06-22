package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class DownLeft implements MovableDirection {
    private final static DownLeft instance = new DownLeft();
    private final int maxDistance;

    private DownLeft() {
        maxDistance = Board.HEIGHT - 1;
    }

    public static DownLeft getInstance() {
        return instance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= -maxDistance && gapI <= -1) && (gapJ >= 1 && gapJ <= maxDistance) && (Math.abs(gapI) == Math.abs(gapJ));
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int i = from.getIndexI() + 1; i < to.getIndexI(); i++) {
            final int j = from.getIndexJ() - (Math.abs(from.getIndexI() - i));
            if (Board.getChessmenByIndex(i, j) != null) return true;
        }

        return false;
    }
}
