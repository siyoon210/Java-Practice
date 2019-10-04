package uml_for_java_programmers.p24_phone_exam.no_adpater;

public class Main {
    public static void main(String[] args) {
        ButtonListener dialer = new Dialer();
        Button digitOneButton = new Button("1", dialer);
        Button digitTwoButton = new Button("2", dialer);
        Button sendButton = new Button("send", dialer);

        digitOneButton.버튼_누르기();
        digitTwoButton.버튼_누르기();
        sendButton.버튼_누르기();
    }
}
