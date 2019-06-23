package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Queen(퀸)의 행마 방식
 * 퀸은 상하좌우 + 대각선 4 방향까지 총 8방향으로, 거리 제한 없이 움직일 수 있다. (다른 말을 뛰어넘을 순 없다.)
 */
public class Queen extends Chessman {
    private final Set<Direction> movableDirections = new HashSet<>();

    public Queen(final Color color) {
        this.color = color;
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections.add(Up.getInstance());
        movableDirections.add(Down.getInstance());
        movableDirections.add(Left.getInstance());
        movableDirections.add(Right.getInstance());
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
        final char charValue = 'q';
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
