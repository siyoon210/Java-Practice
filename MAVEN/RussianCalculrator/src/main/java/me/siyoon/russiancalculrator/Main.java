package me.siyoon.russiancalculrator;

public class Main {
    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder(17, 59);
        pathFinder.searchPath();
        System.out.println("끝");
    }
}
