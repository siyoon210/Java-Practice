package me.siyoon.chessman.direction;

import me.siyoon.Board;

public class Up implements MovableDirection {
    private final int maxDistance;

    public Up() {
        maxDistance = Board.HEIGHT - 1;
    }

    public Up(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean isValidMovement(final Board from, final Board to) {
        return isValidCoordinate(from, to) && !hasOtherChessmanOnPath(from, to);
    }

    private boolean isValidCoordinate(final Board from, final Board to) {
        final int gapI = from.getIndexI() - to.getIndexI();
        final int gapJ = from.getIndexJ() - to.getIndexJ();

        return (gapI >= 1 && gapI <= maxDistance) && gapJ == 0;
    }

    private boolean hasOtherChessmanOnPath(final Board from, final Board to) {
        for (int i = from.getIndexI() - 1; i > to.getIndexI(); i--) {
            if (Board.getChessmenByIndex(i, from.getIndexJ()) != null) return true;
        }

        return false;
    }
}
