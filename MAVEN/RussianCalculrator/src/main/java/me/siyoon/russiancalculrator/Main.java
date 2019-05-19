package me.siyoon.russiancalculrator;

public class Main {
    public static void main(String[] args) {
        System.out.println("시작");
        PathFinder pathFinder = new PathPrinter(59, 17);
        pathFinder.searchPath();
        System.out.println("끝");
    }
}
