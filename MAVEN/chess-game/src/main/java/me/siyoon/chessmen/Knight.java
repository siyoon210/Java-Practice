package me.siyoon.chessmen;

import me.siyoon.Board;

public class Knight extends Chessmen {
    private final char charValue = 'p';

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canBeMoveTo(Board to) {
        return true;
    }

    @Override
    public char getCharValue() {
        if (super.color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }

        return charValue;
    }
}
