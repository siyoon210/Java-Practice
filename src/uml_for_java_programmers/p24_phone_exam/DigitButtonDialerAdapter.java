package uml_for_java_programmers.p24_phone_exam;

public class DigitButtonDialerAdapter implements ButtonListener {
    private int digit;
    private Dialer dialer;

    public DigitButtonDialerAdapter(final int digit, final Dialer dialer) {
        this.digit = digit;
        this.dialer = dialer;
    }

    @Override
    public void buttonPressed() {
        dialer.digit(digit);
    }
}
