package my.examples.javaexam;

public class Exam02 {
    public static void main(String[] args) {
//        Car는 추상클래스이기 떄문에 인스턴스가 될 수 없다.
//        Car c1 = new Car();
        Bus bus = new Bus();
        bus.run();
        bus.안내방송();

        Car bus2 = new Bus();
        bus2.run();
//        bus2.안내방송(); //에러발생

        SportCar sportCar = new SportCar();
        sportCar.run();

        Car s2 = new SportCar();
        s2.run();
    }
}
