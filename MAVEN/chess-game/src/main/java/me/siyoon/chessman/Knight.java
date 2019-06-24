package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Knight(나이트)의 행마 방식
 * 나이트는 L자 모양으로 움직인다. 전진방향으로 2칸 전진방향을 기준으로 좌,우 1칸중 하나로 움직인다.
 * 그래서 총 8칸의 행마를 가진다.
 * 유일하게 경로에 다른 체스말이 있는지 없는지 신경쓰지 않고 넘어 다닐 수 있다.
 */
public class Knight extends Chessman {
    private Direction movableDirection;

    public Knight(final Color color) {
        this.color = color;
        movableDirection = KnightDirection.getInstance();
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        if(isCapturingSameColor(to)) return false;

        return movableDirection.isValidMovement(from, to);
    }

    private boolean isCapturingSameColor(final Board to) {
        return (to.getChessman() != null) && (to.getChessman().getColor() == color);
    }

    @Override
    public char getCharValue() {
        final char charValue = 'n';
        return color == Color.BLACK ? Character.toUpperCase(charValue) : charValue;
    }
}
