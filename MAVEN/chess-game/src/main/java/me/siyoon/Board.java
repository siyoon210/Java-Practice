package me.siyoon;

import me.siyoon.chessman.*;

public enum Board {
    a8(0,0), b8(0,1), c8(0,2), d8(0,3), e8(0,4), f8(0,5), g8(0,6), h8(0,7),
    a7(1,0), b7(1,1), c7(1,2), d7(1,3), e7(1,4), f7(1,5), g7(1,6), h7(1,7),
    a6(2,0), b6(2,1), c6(2,2), d6(2,3), e6(2,4), f6(2,5), g6(2,6), h6(2,7),
    a5(3,0), b5(3,1), c5(3,2), d5(3,3), e5(3,4), f5(3,5), g5(3,6), h5(3,7),
    a4(4,0), b4(4,1), c4(4,2), d4(4,3), e4(4,4), f4(4,5), g4(4,6), h4(4,7),
    a3(5,0), b3(5,1), c3(5,2), d3(5,3), e3(5,4), f3(5,5), g3(5,6), h3(5,7),
    a2(6,0), b2(6,1), c2(6,2), d2(6,3), e2(6,4), f2(6,5), g2(6,6), h2(6,7),
    a1(7,0), b1(7,1), c1(7,2), d1(7,3), e1(7,4), f1(7,5), g1(7,6), h1(7,7);

    public final static int WIDTH = 8;
    public final static int HEIGHT = 8;
    public static Board whiteKingPosition = Board.e1;
    public static Board blackKingPosition = Board.e8;
    private final Coordinate coordinate;
    private Chessman chessman;

    Board(final int i, final int j) {
        coordinate = new Coordinate(i, j);
    }

    public static Board getBoardByIndex(final int i, final int j) {
        final char c = (char)('a' + j);
        final int n = WIDTH - i;

        return Board.valueOf(c + String.valueOf(n));
    }

    public static Chessman getChessmenByIndex(final int i, final int j) {
        return Board.getBoardByIndex(i, j).getChessman();
    }

    public boolean shiftChessman(Board to) {
        if (chessman == null) return false;

        if (chessman.canBeMoveTo(this, to)) {
            to.setChessman(chessman);
            chessman = null;
            ifChessmanIsKingAdjustPosition(to);
            return true;
        }

        return false;
    }

    private void ifChessmanIsKingAdjustPosition(final Board to) {
        if (chessman instanceof King) {
            switch (chessman.getColor()) {
                case BLACK:
                    blackKingPosition = to;
                    break;
                case WHITE:
                    whiteKingPosition = to;
                    break;
                default:
                    throw new RuntimeException("Color값이 이상하다.");
            }
        }
    }

    public int getIndexI() {
        return coordinate.i;
    }

    public int getIndexJ() {
        return coordinate.j;
    }

    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(final Chessman chessman) {
        this.chessman = chessman;
    }

    public static class Coordinate{
        private int i;
        private int j;

        private Coordinate(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void initBoard() {
        Board.a8.setChessman(new Rook(Chessman.Color.BLACK));
        Board.b8.setChessman(new Knight(Chessman.Color.BLACK));
        Board.c8.setChessman(new Bishop(Chessman.Color.BLACK));
        Board.d8.setChessman(new Queen(Chessman.Color.BLACK));
        Board.e8.setChessman(new King(Chessman.Color.BLACK));
        Board.f8.setChessman(new Bishop(Chessman.Color.BLACK));
        Board.g8.setChessman(new Knight(Chessman.Color.BLACK));
        Board.h8.setChessman(new Rook(Chessman.Color.BLACK));

        Board.a7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.b7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.c7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.d7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.e7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.f7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.g7.setChessman(new Pawn(Chessman.Color.BLACK));
        Board.h7.setChessman(new Pawn(Chessman.Color.BLACK));

        Board.a2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.b2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.c2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.d2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.e2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.f2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.g2.setChessman(new Pawn(Chessman.Color.WHITE));
        Board.h2.setChessman(new Pawn(Chessman.Color.WHITE));

        Board.a1.setChessman(new Rook(Chessman.Color.WHITE));
        Board.b1.setChessman(new Knight(Chessman.Color.WHITE));
        Board.c1.setChessman(new Bishop(Chessman.Color.WHITE));
        Board.d1.setChessman(new Queen(Chessman.Color.WHITE));
        Board.e1.setChessman(new King(Chessman.Color.WHITE));
        Board.f1.setChessman(new Bishop(Chessman.Color.WHITE));
        Board.g1.setChessman(new Knight(Chessman.Color.WHITE));
        Board.h1.setChessman(new Rook(Chessman.Color.WHITE));
    }
}
