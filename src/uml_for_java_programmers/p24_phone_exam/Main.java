package uml_for_java_programmers.p24_phone_exam;

public class Main {
    public static void main(String[] args) {
        Dialer dialer = new Dialer();

        ButtonListener digitOneButtonListener = new DigitButtonDialerAdapter(1, dialer);
        Button digitOneButton = new Button(digitOneButtonListener);

        digitOneButton.버튼_누르기();

        ButtonListener sendButtonListener = new SendButtonDialerAdapter(dialer);
        Button sendButton = new Button(sendButtonListener);

        sendButton.버튼_누르기();
    }
}
