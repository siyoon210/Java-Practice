package me.siyoon;

import me.siyoon.chessman.*;

public class ChessGame {
    private ConsoleView consoleView;
    private ConsoleController controller;
    private boolean whiteTurn;

    public ChessGame() {
        consoleView = new ConsoleView();
        controller = new ConsoleController();
        whiteTurn = true;
    }

    public void initBoard() {
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

                    if ((from.getChessman().getColor() == Chessman.Color.WHITE) && !whiteTurn) {
                        System.out.println("현재는 검은색 말 턴입니다.");
                        continue;
                    } else if ((from.getChessman().getColor() == Chessman.Color.BLACK) && whiteTurn) {
                        System.out.println("현재는 하얀색 말 턴입니다.");
                        continue;
                    }

                    if (from.shiftChessman(to)) {
                        whiteTurn = !whiteTurn;
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("입력이 잘못 되었습니다.");
                }
            } else if ("start".equals(input[0])) {
                System.out.println("시작합니다.");
            } else if ("end".equals(input[0])) {
                System.out.println("종료합니다.");
            } else if ("status".equals(input[0])) {
                System.out.println("점수를 표시합니다.");
            } else {
                System.out.println("입력이 잘못 되었습니다.");
            }
        }
    }
}
