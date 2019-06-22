package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class KnightDirection implements Direction {
    private final static KnightDirection instance = new KnightDirection();

    public static KnightDirection getInstance() {
        return instance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        if (gapI == 2 && Math.abs(gapJ) == 1) {
            return true;
        } else if (Math.abs(gapI) == 1 && gapJ == -2) {
            return true;
        } else if (gapI == -2 && Math.abs(gapJ) == 1) {
            return true;
        }

        return Math.abs(gapI) == 1 && gapJ == 2;
    }
}
