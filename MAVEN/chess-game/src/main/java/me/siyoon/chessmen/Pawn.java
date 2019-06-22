package me.siyoon.chessmen;

import me.siyoon.Board;

/**
 * Pawn(폰)의 행마 방식
 * 1. 폰은 앞쪽으로만 1칸씩 전진 할 수 있다. (검정은 보드 판 기준 아래로, 하양은 위로)
 * 2. 한번도 움직이지 않은 폰은 맨 처음에 2칸까지 전진 할 수 있다. (뛰어 넘을 수 없다.)
 * 3. 전진하는 방향으로 대각선에 위치한 말만을 잡을 수 있다.
 * 4. 특수규칙 (앙파상, 승급)은 일단 제외한다.
 */
public class Pawn extends Chessmen {
    private final char charValue = 'p';
    private boolean hasBeenMoved;

    public Pawn(final Color color) {
        super(color);
        hasBeenMoved = false;
    }

    @Override
    public boolean canBeMoveTo(final Board from, final Board to) {
        final Board.Coordinate fromCoordinate = from.getCoordinate();
        final Board.Coordinate toCoordinate = to.getCoordinate();

        final int gapI = fromCoordinate.getI() - toCoordinate.getI();
        final int gapJ = fromCoordinate.getJ() - toCoordinate.getJ();

        switch (super.color) {
            case BLACK:
                if (hasBeenMoved) {
                    return gapI == -1 && gapJ == 0;
                }

                if ((gapI == -1 || gapI == -2) && gapJ == 0) {
                    hasBeenMoved = true;
                    return true;
                }
                return false;
            case WHITE:
                if (hasBeenMoved) {
                    return gapI == 1 && gapJ == 0;
                }

                if ((gapI == 1 || gapI == 2) && gapJ == 0) {
                    hasBeenMoved = true;
                    return true;
                }
                return false;
            default:
                throw new RuntimeException("Color 값이 이상하다. 이런건 존재할 수 없어!");
        }
    }

    @Override
    public char getCharValue() {
        if (super.color == Color.BLACK) {
            return Character.toUpperCase(charValue);
        }
        return charValue;
    }
}
