package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.direction.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Pawn(폰)의 행마 방식
 * 1. 폰은 앞쪽으로만 1칸씩 전진 할 수 있다. (검정은 보드 판 기준 아래로, 하양은 위로)
 * 2. 한번도 움직이지 않은 폰은 맨 처음에 2칸까지 전진 할 수 있다. (다른 말을 뛰어 넘을 순 없다.)
 * 3. 전진하는 방향으로 한칸 대각선에 위치한 말만을 잡을 수 있다.
 * 4. 특수규칙 (앙파상, 승급)은 일단 제외한다.
 */
public class Pawn extends Chessman {
    private boolean hasBeenMoved;
    private Direction movableDirection;
    private Direction movableDirectionWhenFirstMovement;
    private final Set<Direction> attackableDirections = new HashSet<>();

    public Pawn(final Color color) {
        this.color = color;
        hasBeenMoved = false;
        setDirections(color);
    }

    private void setDirections(final Color color) {
        switch (color) {
            case BLACK:
                movableDirection = Down.getInstance(1);
                movableDirectionWhenFirstMovement = Down.getInstance(2);
                attackableDirections.add(DownLeft.getInstance(1));
                attackableDirections.add(DownRight.getInstance(1));
                return;
            case WHITE:
                movableDirection = Up.getInstance(1);
                movableDirectionWhenFirstMovement = Up.getInstance(2);
                attackableDirections.add(UpLeft.getInstance(1));
                attackableDirections.add(UpRight.getInstance(1));
                return;
            default:
                throw new RuntimeException("Color 값이 이상하다.");
        }
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        if (isCapturingMovement(from, to)) {
            hasBeenMoved = true;
            return true;
        }

        return hasBeenMoved ? commonMovementCase(from, to) : firstMovementCase(from, to);
    }

    private boolean isCapturingMovement(final Board from, final Board to) {
        return attackableDirections.stream().anyMatch(a -> a.isValidMovement(from, to))
                && (to.getChessman() != null && to.getChessman().getColor() != color);
    }

    private boolean commonMovementCase(final Board from, final Board to) {
        return movableDirection.isValidMovement(from, to) && to.getChessman() == null;
    }

    private boolean firstMovementCase(final Board from, final Board to) {
        if (movableDirectionWhenFirstMovement.isValidMovement(from, to) && to.getChessman() == null) {
            hasBeenMoved = true;
            return true;
        }

        return false;
    }
}
