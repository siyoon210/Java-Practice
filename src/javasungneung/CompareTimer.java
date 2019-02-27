package javasungneung;

public class CompareTimer {
    public static void main(String[] args) {
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            //시작시간
            long startTime = System.nanoTime();

            for (int j = 0; j < 10000; j++) {
//                str += "abcde";
//                stringBuffer.append("abcde");
                stringBuilder.append("abcde");
            }

            //종료시간
            long endTime = System.nanoTime();

            //종료시간 - 시작시간은 = 걸린 시간
            Double elapsedTime = (endTime - startTime) / 1000000.0;
            System.out.println(elapsedTime);
        }
    }
}
