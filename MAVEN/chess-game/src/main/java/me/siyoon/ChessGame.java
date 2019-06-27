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

    public void run() {
        Board.initBoard();

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

                    if (from.getChessman() !=null &&(from.getChessman().getColor() == Chessman.Color.WHITE) && !whiteTurn) {
                        System.out.println("현재는 검은색 말 턴입니다.");
                        continue;
                    } else if (from.getChessman() !=null && (from.getChessman().getColor() == Chessman.Color.BLACK) && whiteTurn) {
                        System.out.println("현재는 하얀색 말 턴입니다.");
                        continue;
                    }

                    if (from.shiftChessman(to)) {
                        whiteTurn = !whiteTurn;
                        return;
                    } else{
                        System.out.println("유효하지 않은 움직임");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("입력이 잘못 되었습니다. 좌표값 ");
                }
            } else if ("start".equals(input[0])) {
                System.out.println("시작합니다.");
            } else if ("end".equals(input[0])) {
                System.out.println("종료합니다.");
            } else if ("status".equals(input[0])) {
                System.out.println("점수를 표시합니다.");
            } else {
                System.out.println("입력이 잘못 되었습니다. else 문");
            }
        }
    }
}
