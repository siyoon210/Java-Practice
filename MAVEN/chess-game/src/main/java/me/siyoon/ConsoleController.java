package me.siyoon;

import java.util.Scanner;

public class ConsoleController implements UserControl{
    private Scanner sc = new Scanner(System.in);

//    public String[] input(){
//
//    }

    @Override
    public Action getAction() {
        final String input = sc.nextLine();
        final String[] s = input.split(" ");

        if (s[0].equals("move")) {
            return Action.Move;
        }

        return null;
    }
}
