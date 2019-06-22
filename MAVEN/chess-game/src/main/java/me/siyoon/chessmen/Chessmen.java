package me.siyoon.chessmen;

import me.siyoon.Board;

public abstract class Chessmen {
    public abstract boolean canBeMoveTo(Board from, Board to);
    public abstract char getCharValue();
}
