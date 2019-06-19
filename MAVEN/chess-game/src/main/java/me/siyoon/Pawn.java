package me.siyoon;

public class Pawn extends Chessmen {
    private final char charValue = 'p';

    @Override
    public boolean moveTo(Board to) {
        return false;
    }

    @Override
    public char getCharValue() {
        return charValue;
    }
}
