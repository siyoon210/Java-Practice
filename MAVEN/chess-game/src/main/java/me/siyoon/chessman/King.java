package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * King(킹)의 행마 방식
 * 킹은 상하좌우와 대각선 4방향으로 총 8방향을 1칸씩만 움직일 수 있다.
 */
public class King extends Chessman {
    private final Set<Direction> movableDirections = new HashSet<>();

    public King(final Color color) {
        this.color = color;
        setMovableDirections();
    }

    private void setMovableDirections() {
        movableDirections.add(Up.getInstance(1));
        movableDirections.add(Down.getInstance(1));
        movableDirections.add(Left.getInstance(1));
        movableDirections.add(Right.getInstance(1));
        movableDirections.add(UpLeft.getInstance(1));
        movableDirections.add(UpRight.getInstance(1));
        movableDirections.add(DownLeft.getInstance(1));
        movableDirections.add(DownRight.getInstance(1));
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        if(isCapturingSameColor(to)) return false;

        return movableDirections.stream().anyMatch(m -> m.isValidMovement(from, to));
    }

    private boolean isCapturingSameColor(final Board to) {
        return (to.getChessman() != null) && (to.getChessman().getColor() == color);
    }
}
