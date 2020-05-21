package effective_java.item61;

public class Code61_3 {
    static Integer i;

    public static void main(String[] args) {
        //기본타입과 박싱된 기본타입을 혼용한 연산에서는 박싱된 기본타입의 박싱이 자동으로 풀린다.
        //즉, 기본타입 '42'이랑 비교해야겠군! 하는순간 'i.intValue()'를 호출 할 텐데, null이니까 NPE가 터져부려
        if (i == 42) {
            System.out.println("믿을 수 없군");
        }
    }
}
