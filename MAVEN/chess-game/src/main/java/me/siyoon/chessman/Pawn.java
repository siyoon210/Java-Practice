package me.siyoon.chessman;

import me.siyoon.Board;
import me.siyoon.chessman.movablerange.Down;
import me.siyoon.chessman.movablerange.MovableRange;
import me.siyoon.chessman.movablerange.Up;

/**
 * Pawn(폰)의 행마 방식
 * 1. 폰은 앞쪽으로만 1칸씩 전진 할 수 있다. (검정은 보드 판 기준 아래로, 하양은 위로)
 * 2. 한번도 움직이지 않은 폰은 맨 처음에 2칸까지 전진 할 수 있다. (뛰어 넘을 수 없다.)
 * 3. 전진하는 방향으로 대각선에 위치한 말만을 잡을 수 있다.
 * 4. 특수규칙 (앙파상, 승급)은 일단 제외한다.
 */
public class Pawn extends Chessman {
    private Color color;
    private final char charValue = 'p';
    private boolean hasBeenMoved;
    private MovableRange movableRange;

    public Pawn(final Color color) {
        this.color = color;
        hasBeenMoved = false;

        switch (color) {
            case BLACK:
                movableRange = new Down(1);
                break;
            case WHITE:
                movableRange = new Up(1);
                break;
            default:
                throw new RuntimeException("Color 값이 이상하다.");
        }
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        if (hasBeenMoved) {
            return movableRange.isInRange(from, to);
        }

        switch (color) {
            case BLACK:
                if (new Down(2).isInRange(from, to)) {
                    hasBeenMoved = true;
                    return true;
                }
                return false;
            case WHITE:
                if (new Up(2).isInRange(from, to)) {
                    hasBeenMoved = true;
                    return true;
                }
                return false;
            default:
                throw new RuntimeException("Color 값이 이상하다.");
        }
    }

    @Override
    public char getCharValue() {
        if (color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
