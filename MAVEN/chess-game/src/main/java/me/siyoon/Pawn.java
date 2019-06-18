package me.siyoon;

public class Pawn extends Chessmen {
    private final char charValue = 'p';

    public Pawn(Board board) {
        super(board);
    }

    @Override
    public boolean move() {
        return false;
    }
}
