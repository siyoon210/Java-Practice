package me.siyoon;

public abstract class Chessmen {
    private Coordinate coordinate;

    public Chessmen(final Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract boolean move();
}
