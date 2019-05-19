package me.siyoon.russiancalculator;

import me.siyoon.russiancalculrator.PathFinder;
import org.junit.Before;
import org.junit.Test;

public class PathFinderTest {
    private PathFinder pathFinder;

    @Before
    public void init() {
        int maxCount = 5;
        int targetNum = 61;
        pathFinder = new PathFinder(maxCount, targetNum);
    }

    @Test
    public void searchTest() {
        pathFinder.searchPath();
    }
}
