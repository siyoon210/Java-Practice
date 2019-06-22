package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.movablerange.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Rook(룩)의 행마 방식
 * 룩은 상하좌우 방향으로, 거리 제한 없이 움직일 수 있다. (다른 말을 뛰어넘을 순 없다.)
 */
public class Rook extends Chessman {
    private Color color;
    private final char charValue = 'r';
    private Set<MovableRange> movableRanges;

    public Rook(final Color color) {
        this.color = color;
        setMovableRanges();
    }

    private void setMovableRanges() {
        movableRanges = new HashSet<>();
        movableRanges.add(new Up());
        movableRanges.add(new Down());
        movableRanges.add(new Left());
        movableRanges.add(new Right());
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        return movableRanges.stream().anyMatch(m -> m.isInRange(from, to));
    }

    @Override
    public char getCharValue() {
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
