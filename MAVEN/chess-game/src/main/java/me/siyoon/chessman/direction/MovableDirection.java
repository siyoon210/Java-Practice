package me.siyoon.chessman.direction;

import me.siyoon.Board;

/**
 * MovableDirection 구현체들인 객체들은 하나만 있어도 되므로 싱글톤 객체로 만들어 진다.
 */
public interface MovableDirection {
    boolean isValidMovement(Board from, Board to);
}
