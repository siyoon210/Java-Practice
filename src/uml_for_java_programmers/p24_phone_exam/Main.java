package uml_for_java_programmers.p24_phone_exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        Dialer dialer = new Dialer(speaker);

        ButtonListener digitOneButtonListener = new DigitButtonDialerAdapter(1, dialer);
        Button digitOneButton = new Button(digitOneButtonListener);

        ButtonListener digitTwoButtonListener = new DigitButtonDialerAdapter(2, dialer);
        Button digitTwoButton = new Button(digitTwoButtonListener);

        ButtonListener sendButtonListener = new SendButtonDialerAdapter(dialer);
        Button sendButton = new Button(sendButtonListener);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            final String next = scanner.next();

            switch (next) {
                case "1":
                    digitOneButton.버튼_누르기();
                    break;
                case "2":
                    digitTwoButton.버튼_누르기();
                    break;
                case "send":
                    sendButton.버튼_누르기();
                    break;
                default:
                    break;
            }
        }
    }
}
