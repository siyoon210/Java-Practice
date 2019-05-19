package me.siyoon.russiancalculrator;

public class PathFinderImpl implements PathFinder{
    protected final int INIT_NUM = 1;
    private Calculator calculator;
    protected long targetNum;
    private int maxTryCount;

    public PathFinderImpl(long targetNum, int maxTryCount) {
        calculator = new Calculator();
        this.maxTryCount = maxTryCount;
        this.targetNum = targetNum;
    }

    public void searchPath() {
        searchPath(INIT_NUM, 0);
    }

    public void searchPath(final long num, final int tryCount) {
        if (tryCount > maxTryCount) {
            return;
        }

        if (num == targetNum) {
            printPath(tryCount);
        }

        doMultiply(num, tryCount);
        doReverse(num, tryCount);
    }

    protected void printPath(final int tryCount) {
        System.out.println("경로 찾기 성공! (" + tryCount + "번 연산)");
    }

    protected void doMultiply(final long num, final int tryCount) {
        long multiply = calculator.multiply(num);
        searchPath(multiply, tryCount + 1);
    }

    protected void doReverse(final long num, final int tryCount) {
        long reverse = calculator.reverse(num);
        searchPath(reverse, tryCount + 1);
    }
}
