package me.siyoon.russiancalculator;

import me.siyoon.russiancalculrator.PathFinderImpl;
import org.junit.Before;
import org.junit.Test;

public class PathFinderTest {
    private PathFinderImpl pathFinder;

    @Before
    public void init() {
        int maxCount = 5;
        int targetNum = 61;
        pathFinder = new PathFinderImpl(maxCount, targetNum);
    }

    @Test
    public void searchTest() {
        pathFinder.searchPath();
    }
}
