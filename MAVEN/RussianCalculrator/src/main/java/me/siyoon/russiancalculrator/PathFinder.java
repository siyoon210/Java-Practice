package me.siyoon.russiancalculrator;

import java.util.LinkedList;

public class PathFinder {
    private final int INIT_NUM = 1;
    private Calculator calculator;
    private long targetNum;
    private LinkedList<String> actions;
    private int maxTryCount;

    public PathFinder(int maxTryCount, long targetNum) {
        calculator = new Calculator();
        actions = new LinkedList<String>();
        this.maxTryCount = maxTryCount;
        this.targetNum = targetNum;
    }

    public void searchPath() {
        searchPath(INIT_NUM, 0);
    }

    public void searchPath(final long num, int tryCount) {
        if (tryCount > maxTryCount) {
            return;
        }

        if (num == targetNum) {
            for (final String action : actions) {
                System.out.print(action + " -> ");
            }
            System.out.println("카운트는 " + tryCount);
            System.out.println("=======");
        }

        long multiply = calculator.multiply(num);
        actions.add("x2 (" + multiply + ")");
        searchPath(multiply, tryCount + 1);
        actions.removeLast();

        long reverse = calculator.reverse(num);
        actions.add("reverse (" + reverse + ")");
        searchPath(reverse, tryCount + 1);
        actions.removeLast();
    }
}
