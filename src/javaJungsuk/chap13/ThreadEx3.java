package javaJungsuk.chap13;

public class ThreadEx3 {
    public static void main(String[] args) throws Exception{
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
        //쓰레드예제2는 스타트로 호출 하였고 예제3은 런으로 호출하였다.
        // 스타트 메서드는 새로운 호출스택을 생성하고 그곳에 run()메소드를 만들어 주는 것을 이예제로 알수있다.
        //예제2에서는 메인은 다른 호출스택에 있으므로 이미 종료 되었고,
        //예제3은 한 호출스택에서 예외가 발생되어 메인까지 멈추게 되었다.
    }
}

class ThreadEx3_1 extends Thread{
    @Override
    public void run() {
        throwException();
    }

    public void throwException(){
        try{
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}