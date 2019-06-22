package me.siyoon;

import me.siyoon.chessman.Color;
import me.siyoon.chessman.Pawn;
import me.siyoon.chessman.Rook;

public class ChessGame {
    private ConsoleView consoleView;
    private ConsoleController controller;

    public ChessGame() {
        consoleView = new ConsoleView();
        controller = new ConsoleController();
    }

    public void initBoard() {
        Board.a8.setChessman(new Rook(Color.BLACK));
        Board.h8.setChessman(new Rook(Color.BLACK));

        Board.a7.setChessman(new Pawn(Color.BLACK));
        Board.b7.setChessman(new Pawn(Color.BLACK));
        Board.c7.setChessman(new Pawn(Color.BLACK));
        Board.d7.setChessman(new Pawn(Color.BLACK));
        Board.e7.setChessman(new Pawn(Color.BLACK));
        Board.f7.setChessman(new Pawn(Color.BLACK));
        Board.g7.setChessman(new Pawn(Color.BLACK));
        Board.h7.setChessman(new Pawn(Color.BLACK));


        Board.a1.setChessman(new Rook(Color.WHITE));
        Board.h1.setChessman(new Rook(Color.WHITE));

        Board.a2.setChessman(new Pawn(Color.WHITE));
        Board.b2.setChessman(new Pawn(Color.WHITE));
        Board.c2.setChessman(new Pawn(Color.WHITE));
        Board.d2.setChessman(new Pawn(Color.WHITE));
        Board.e2.setChessman(new Pawn(Color.WHITE));
        Board.f2.setChessman(new Pawn(Color.WHITE));
        Board.g2.setChessman(new Pawn(Color.WHITE));
        Board.h2.setChessman(new Pawn(Color.WHITE));
    }

    public void run() {
        initBoard();

        while (true) {
            consoleView.printBoard();
            input();
        }
    }

    private void input() {
        while (true) {
            final String[] input = controller.input();
            if ("move".equals(input[0])) {
                try {
                    final Board from = Board.valueOf(input[1]);
                    final Board to = Board.valueOf(input[2]);
                    if (from.shiftChessmen(to)) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("입력이 잘못 되었습니다.");
                }
            }
            System.out.println("입력이 잘못 되었습니다.");
        }
    }
}
