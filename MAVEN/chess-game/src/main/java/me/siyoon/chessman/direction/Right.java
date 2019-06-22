package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Right implements MovableDirection {
    private final static Right instance = new Right();
    private final int maxDistance;

    private Right() {
        maxDistance = Board.WIDTH - 1;
    }

    public static Right getInstance() {
        return instance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return gapI == 0 && (gapJ >= -maxDistance && gapJ <= -1);
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int j = from.getIndexJ() + 1; j < to.getIndexJ(); j++) {
            if (Board.getChessmenByIndex(from.getIndexI(), j) != null) return true;
        }

        return false;
    }
}
