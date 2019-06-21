package me.siyoon.chessmen;

import me.siyoon.Board;

public abstract class Chessmen {
    protected Color color;

    public Chessmen(final Color color) {
        this.color = color;
    }

    public abstract boolean canBeMoveTo(Board to);
    public abstract char getCharValue();
}
