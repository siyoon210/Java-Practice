package me.siyoon;

import me.siyoon.chessman.*;

public class ConsoleView {
    public void printBoard() {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                final Chessman chessman = Board.getChessmenByIndex(i, j);
                System.out.print(getCharValue(chessman) + " ");
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
            return '*';
        }

        return chessman.getColor() == Chessman.Color.BLACK ? Character.toUpperCase(charValue) : charValue;
    }
}
