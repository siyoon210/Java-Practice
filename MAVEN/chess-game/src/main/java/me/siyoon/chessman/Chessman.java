package me.siyoon.chessman;

import me.siyoon.Board;

public abstract class Chessman {
    public abstract boolean canBeMoveTo(Board from, Board to);
    public abstract char getCharValue();
}
