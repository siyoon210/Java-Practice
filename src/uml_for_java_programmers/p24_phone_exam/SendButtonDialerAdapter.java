package uml_for_java_programmers.p24_phone_exam;

public class SendButtonDialerAdapter implements ButtonListener {
    private Dialer dialer;

    public SendButtonDialerAdapter(final Dialer dialer) {
        this.dialer = dialer;
    }

    @Override
    public void buttonPressed() {
        dialer.send();
    }
}
