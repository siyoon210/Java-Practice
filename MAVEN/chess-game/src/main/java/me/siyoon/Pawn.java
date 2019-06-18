package me.siyoon;

public class Pawn extends Chessmen {
    private final char charValue = 'p';

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public char getCharValue() {
        return charValue;
    }
}
