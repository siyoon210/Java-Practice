package uml_for_java_programmers.p24_phone_exam.no_adpater;

public class Button {
    private String token;
    private ButtonListener buttonListener;

    public Button(final String token, final ButtonListener buttonListener) {
        this.token = token;
        this.buttonListener = buttonListener;
    }

    public void 버튼_누르기() {
        buttonListener.buttonPressed(token);
    }
}
