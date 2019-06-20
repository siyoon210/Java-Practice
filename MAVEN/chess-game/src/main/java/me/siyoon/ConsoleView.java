package me.siyoon;

import me.siyoon.chessmen.Chessmen;

public class ConsoleView {
    private static final char EMPTY_COORDINATE_VALLUE = '*';

    public void printBoard() {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                final Chessmen chessmen = Board.getBoardByIndex(i, j).getChessmen();
                if (chessmen == null) {
                    System.out.print(EMPTY_COORDINATE_VALLUE + " ");
                } else {
                    System.out.println(chessmen.getCharValue());
                }
            }
            System.out.println(Board.WIDTH - i);
        }

        for (int i = 0; i < Board.WIDTH; i++) {
            System.out.print((char)('a' + i) + " ");
        }
    }
}
