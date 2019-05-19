package me.siyoon.russiancalculator;

import me.siyoon.russiancalculrator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void multiply() {
        long num = 2;

        long result = calculator.multiply(num);

        Assert.assertEquals(result, 4);
    }

    @Test
    public void reverse() {
        long num1 = 1L;
        long num2 = 20L;
        long num3 = 300L;
        long num4 = 61L;
        long num5 = 123L;
        long num6 = 1002L;
        long num7 = 5700L;

        Assert.assertEquals(calculator.reverse(num1), 1L);
        Assert.assertEquals(calculator.reverse(num2), 2L);
        Assert.assertEquals(calculator.reverse(num3), 3L);
        Assert.assertEquals(calculator.reverse(num4), 16L);
        Assert.assertEquals(calculator.reverse(num5), 321L);
        Assert.assertEquals(calculator.reverse(num6), 2001L);
        Assert.assertEquals(calculator.reverse(num7), 705L);
    }
}
