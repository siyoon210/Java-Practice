package me.siyoon;

public class Pawn extends Chessmen {
    private final char charValue = 'p';

    public Pawn(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public boolean move() {
        return false;
    }
}
