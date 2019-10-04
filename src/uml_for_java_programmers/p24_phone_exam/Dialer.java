package uml_for_java_programmers.p24_phone_exam;

public class Dialer {
    private Speaker speaker;

    public Dialer(final Speaker speaker) {
        this.speaker = speaker;
    }

    public void digit(int n) {
        speaker.tone();
        System.out.println(n + " 눌림!");
    }

    public void send() {
        speaker.tone();
        System.out.println("send 눌림!");
    }
}
