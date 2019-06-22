package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Down implements MovableDirection {
    private final int distance;

    public Down() {
        distance = Board.HEIGHT;
    }

    public Down(final int distance) {
        this.distance = distance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= -distance && gapI <= -1) && gapJ == 0;
    }
}
