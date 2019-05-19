package me.siyoon.russiancalculrator;

import java.util.LinkedList;

public class PathPrinter extends PathFinderImpl {
    private LinkedList<String> actions;

    public PathPrinter(final long targetNum, final int maxTryCount) {
        super(targetNum, maxTryCount);
        initActions();
    }

    private void initActions() {
        actions = new LinkedList<String>();
    }

    @Override
    public void searchPath() {
        super.searchPath();
    }

    @Override
    public void searchPath(final long num, final int tryCount) {
        super.searchPath(num, tryCount);
    }

    @Override
    protected void printPath(final int tryCount) {
        super.printPath(tryCount);

        for (final String action : actions) {
            System.out.print(action);
        }

        System.out.print("[" + super.targetNum + "]");
        System.out.println();
        System.out.println();
    }

    @Override
    protected void doMultiply(final long num, final int tryCount) {
        actions.add("(" + num + ") x2 = ");
        super.doMultiply(num, tryCount);
        actions.removeLast();
    }

    @Override
    protected void doReverse(final long num, final int tryCount) {
        actions.add("(" + num + ") reverse = ");
        super.doReverse(num, tryCount);
        actions.removeLast();
    }
}
