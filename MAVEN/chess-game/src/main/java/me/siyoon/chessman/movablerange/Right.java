package me.siyoon.chessman.movablerange;

import me.siyoon.Board;

public class Right extends MovableRange {
    private final int distance;

    public Right() {
        distance = Board.WIDTH;
    }

    @Override
    public boolean isInRange(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return gapI == 0 && (gapJ >= 1 && gapJ <= distance);
    }
}
