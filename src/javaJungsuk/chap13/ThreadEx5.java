package javaJungsuk.chap13;

public class ThreadEx5 {
    static long startTIme = 0;

    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        for(int i=0; i<500; i++){
            System.out.printf("%s", new String("-")); //new String을 쓰는이유는 연산속도를 늦추기 위함
        }
        System.out.print("소요시간1: " +(System.currentTimeMillis()-ThreadEx5.startTIme));



    }
}

class ThreadEx5_1 extends Thread{
    @Override
    public void run() {
        for (int i=0; i<500; i++){
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간2: " +(System.currentTimeMillis()-ThreadEx5.startTIme));
    }
}