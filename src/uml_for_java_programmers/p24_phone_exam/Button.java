package uml_for_java_programmers.p24_phone_exam;

public class Button {
    private ButtonListener buttonListener;

    public Button(final ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    public void 버튼_누르기() {
        buttonListener.buttonPressed();
    }
}
