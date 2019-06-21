package me.siyoon;

import me.siyoon.chessmen.Color;
import me.siyoon.chessmen.Pawn;

public class ChessGame {
    private ConsoleView consoleView;
    private ConsoleController controller;

    public ChessGame() {
        consoleView = new ConsoleView();
        controller = new ConsoleController();
    }

    public void initBoard() {
        Board.a8.setChessmen(new Pawn(Color.BLACK));
        Board.b8.setChessmen(new Pawn(Color.BLACK));
        Board.c8.setChessmen(new Pawn(Color.BLACK));
        Board.d8.setChessmen(new Pawn(Color.BLACK));

        Board.a1.setChessmen(new Pawn(Color.WHITE));
        Board.b1.setChessmen(new Pawn(Color.WHITE));
        Board.c1.setChessmen(new Pawn(Color.WHITE));
        Board.d1.setChessmen(new Pawn(Color.WHITE));
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
                    from.moveChessmen(to);
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("입력이 잘못 되었습니다.");
                }
            }
        }
    }
}
