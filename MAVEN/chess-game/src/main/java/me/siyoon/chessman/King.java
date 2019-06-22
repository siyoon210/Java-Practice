package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * King(킹)의 행마 방식
 * 킹은 상하좌우 방향으로, 1칸씩만 움직일 수 있다.
 */
public class King extends Chessman {
    private final Set<Direction> movableDirections = new HashSet<>();

    public King(final Color color) {
        super(color);
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections.add(Up.getInstance(1));
        movableDirections.add(Down.getInstance(1));
        movableDirections.add(Left.getInstance(1));
        movableDirections.add(Right.getInstance(1));
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        return movableDirections.stream().anyMatch(m -> m.isValidMovement(from, to));
    }

    @Override
    public char getCharValue() {
        final char charValue = 'k';
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
