package uml_for_java_programmers.p24_phone_exam.no_adpater;

public class Dialer implements ButtonListener {
    @Override
    public void buttonPressed(String token) {
        switch (token) {
            case "1":
                System.out.println("1 눌림");
                break;
            case "2":
                System.out.println("2 눌림");
                break;
            case "send":
                System.out.println("send 눌림");
                break;
            default:
                System.out.println("알수없는 버튼 눌림");
        }
    }
}
