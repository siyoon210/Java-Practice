package me.siyoon;

import me.siyoon.chessman.Chessman;

public class ConsoleView {
    private static final char EMPTY_COORDINATE_VALUE = '*';

    public void printBoard() {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                final Chessman chessman = Board.getChessmenByIndex(i, j);
                if (chessman == null) {
                    System.out.print(EMPTY_COORDINATE_VALUE + " ");
                } else {
                    System.out.print(chessman.getCharValue() + " ");
                }
            }
            System.out.println(Board.WIDTH - i);
        }

        for (int i = 0; i < Board.WIDTH; i++) {
            System.out.print((char)('a' + i) + " ");
        }
        System.out.println();
    }
}
