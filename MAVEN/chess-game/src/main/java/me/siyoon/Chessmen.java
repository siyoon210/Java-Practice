package me.siyoon;

public abstract class Chessmen {
    private Board board;

    public Chessmen(final Board board) {
        this.board = board;
    }

    public abstract boolean move();
}
