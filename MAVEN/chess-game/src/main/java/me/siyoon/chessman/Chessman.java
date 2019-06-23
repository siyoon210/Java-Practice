package me.siyoon.chessman;

import me.siyoon.Board;

public abstract class Chessman {
    public enum Color {BLACK, WHITE}

    Color color;

    public abstract boolean canBeMoveTo(Board from, Board to);

    public abstract char getCharValue();

    public Color getColor() {
        return color;
    }
}
