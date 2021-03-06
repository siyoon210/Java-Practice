package practice.binaryoperator;

public class BinOper {
    public static void main(String[] args) {
        int a = 8;
        String binStr = Integer.toBinaryString(a);
        int b = -7; //11111111111111111111111111111001
        int result2 = -7 >> 2; //11111111111111111111111111111110

        int c = -7; //11111111111111111111111111111001
        int result3 = -7 >>> 20; //111111111111

        String str = "1000";
        System.out.println(Integer.parseInt(str, 2));

        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(b));
        System.out.println(binStr);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(result2);
        System.out.println(Integer.toBinaryString(result2));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(result3);
        System.out.println(Integer.toBinaryString(result3));


        //만약 n가지 경우가 있는 조합을 비트연산으로 알아낼려면?
        int n = 3;
        String format = "%0" + n + "d";
        for (int i = 0; i < 1 << n; i++) {
            System.out.println(String.format(format, Integer.parseInt(Integer.toBinaryString(i))));
        }
    }
}
