package me.siyoon.chessmen.movehelper;

import me.siyoon.Board;

public abstract class MovableRange {
    public abstract boolean isInRange(Board from, Board to);
}
