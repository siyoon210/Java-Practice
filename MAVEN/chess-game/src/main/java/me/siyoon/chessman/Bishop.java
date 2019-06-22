package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Bishop(비숍)의 행마 방식
 * 비셥은 대각선 4 방향으로, 거리 제한 없이 움직일 수 있다. (다른 말을 뛰어넘을 순 없다.)
 */
public class Bishop extends Chessman {
    private final Set<Direction> movableDirections = new HashSet<>();

    public Bishop(final Color color) {
        super(color);
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections.add(UpLeft.getInstance());
        movableDirections.add(UpRight.getInstance());
        movableDirections.add(DownLeft.getInstance());
        movableDirections.add(DownRight.getInstance());
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        return movableDirections.stream().anyMatch(m -> m.isValidMovement(from, to));
    }

    @Override
    public char getCharValue() {
        final char charValue = 'b';
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
