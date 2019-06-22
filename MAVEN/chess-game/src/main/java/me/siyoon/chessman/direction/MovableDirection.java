package me.siyoon.chessman.direction;

import me.siyoon.Board;

public interface MovableDirection {
    boolean isValidMovement(Board from, Board to);
}
