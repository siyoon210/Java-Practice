package me.siyoon.chessmen.movehelper;

import me.siyoon.Board;

public class Down extends MovableRange {
    private int distance;

    public Down() {
        distance = Board.HEIGHT;
    }

    public Down(final int distance) {
        this.distance = distance;
    }

    @Override
    public boolean isInRange(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI <= -1 && gapI >= -distance) && gapJ == 0;
    }
}
