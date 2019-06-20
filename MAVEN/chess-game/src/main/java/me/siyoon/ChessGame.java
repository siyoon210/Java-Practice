package me.siyoon;

public class ChessGame {
    private ConsoleView consoleView;
    private ConsoleController controller;

    public ChessGame() {
        consoleView = new ConsoleView();
        controller = new ConsoleController();
    }

    public void run() {
        consoleView.printBoard();

    }
}
