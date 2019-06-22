package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Rook(룩)의 행마 방식
 * 룩은 상하좌우 방향으로, 거리 제한 없이 움직일 수 있다. (다른 말을 뛰어넘을 순 없다.)
 */
public class Rook extends Chessman {
    private Color color;
    private final char charValue = 'r';
    private Set<MovableDirection> movableDirections;

    public Rook(final Color color) {
        this.color = color;
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections = new HashSet<>();
        movableDirections.add(new Up()); //TODO 똑같은 방향을 매번 new 로 만드느는거 비효율 적인거 같다.
        movableDirections.add(new Down());
        movableDirections.add(new Left());
        movableDirections.add(new Right());
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
//        return movableDirections.stream().anyMatch(m -> m.isValidMovement(from, to));
        for (final MovableDirection movableDirection : movableDirections) {
            if (movableDirection.isValidMovement(from, to)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public char getCharValue() {
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
