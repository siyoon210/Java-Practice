package me.siyoon;

import me.siyoon.chessman.*;

public class ConsoleView {
    private static final char EMPTY_COORDINATE_VALUE = '*';

    public void printBoard() {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                final Chessman chessman = Board.getChessmenByIndex(i, j);
                if (chessman == null) {
                    System.out.print(EMPTY_COORDINATE_VALUE + " ");
                } else {
                    System.out.print(getCharValue(chessman) + " ");
                }
            }
            System.out.println("  " + (Board.WIDTH - i));
        }

        System.out.println();
        for (int i = 0; i < Board.WIDTH; i++) {
            System.out.print((char)('a' + i) + " ");
        }
        System.out.println();
    }

    private char getCharValue(Chessman chessman) {
        char charValue;
        if (chessman instanceof Bishop) {
            charValue = 'b';
        } else if (chessman instanceof King) {
            charValue = 'k';
        } else if (chessman instanceof Knight) {
            charValue = 'n';
        } else if (chessman instanceof Pawn) {
            charValue = 'p';
        } else if (chessman instanceof Queen) {
            charValue = 'q';
        } else if (chessman instanceof Rook) {
            charValue = 'r';
        } else {
            throw new RuntimeException("어디서 이상한 체스말이 들어왔아!!");
        }

        return chessman.getColor() == Chessman.Color.BLACK ? Character.toUpperCase(charValue) : charValue;
    }
}
