package me.siyoon.russiancalculrator;

public class Calculator {
    public long multiply(long number, int multiplyAmount) {
        return number * multiplyAmount;
    }

    public long multiply(long number) {
        return this.multiply(number, 2);
    }

    public long reverse(long number) {
        char[] chars = String.valueOf(number).toCharArray();

        char tmp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = tmp;

        return Long.valueOf(String.valueOf(chars));
    }
}
