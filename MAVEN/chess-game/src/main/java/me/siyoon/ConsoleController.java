package me.siyoon;

import java.util.Scanner;

public class ConsoleController {
    private Scanner sc = new Scanner(System.in);

//    public String[] input(){
//
//    }

    public String[] input() {
        final String input = sc.nextLine();
        final String[] s = input.split(" ");

        return s;
    }
}
