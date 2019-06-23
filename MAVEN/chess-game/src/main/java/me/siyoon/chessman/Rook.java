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
    private final Set<Direction> movableDirections = new HashSet<>();

    public Rook(final Color color) {
        this.color = color;
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections.add(Up.getInstance());
        movableDirections.add(Down.getInstance());
        movableDirections.add(Left.getInstance());
        movableDirections.add(Right.getInstance());
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        if (isCapturingSameColor(to)) return false;

        return movableDirections.stream().anyMatch(m -> m.isValidMovement(from, to));
    }

    private boolean isCapturingSameColor(final Board to) {
        return (to.getChessman() != null) && (to.getChessman().getColor() == color);
    }
}
