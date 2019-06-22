package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Up implements MovableDirection {
    private final int distance;

    public Up() {
        distance = Board.HEIGHT;
    }

    public Up(final int distance) {
        this.distance = distance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= 1 && gapI <= distance) && gapJ == 0;
    }
}
