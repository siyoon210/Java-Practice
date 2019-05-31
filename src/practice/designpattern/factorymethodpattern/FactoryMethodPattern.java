package practice.designpattern.factorymethodpattern;

/**
 * <팩토리 메소드 패턴>
 * 팩토리 메소드 패턴은 객체를 생성하여 반환하는 '팩토리 메소드'와 '상속'을 통한 기능 확장 방법을 얘기한다.
 * 어떤 객체를 사용할지는 상위클래스는 모르는 추상클래스의 역할을 하고, 하위클래스에서는 사용할 객체를 생성한다.
 *
 * 참고 : https://jdm.kr/blog/180
 * 밑에 코드는 위의 블로그를 보고 따라 한거지만
 *
 * 토비 1권에서 말하는 팩토리 메소드 패턴이랑 미묘하게 다른것 같다.
 *
 * 토비에서 말하는 팩토리 메소드 패턴은
 * A클래스가 B클래스를 의존하고 있는데, 이 의존하고 있는 실제 구체 클래스가 뭔지 A클래스의 상위 클래스는 알 수 없다.
 * 이을 상속받은 하위 클래스가 만들어서 의존 시켜 주기 때문, (마치 전략패턴과 비슷하지만 묘하게 다르군)
 */

abstract class Robot {
    public abstract String getName();
}

class SuperRobot extends Robot {
    @Override
    public String getName() {
        return "Super Robot";
    }
}

class PowerRobot extends Robot {
    @Override
    public String getName() {
        return "Power Robot";
    }
}

abstract class RobotFactory {
    abstract Robot createRobot(String name);
}

class SuperRobotFactory extends RobotFactory {
    @Override
    Robot createRobot(final String name) {
        switch (name) {
            case "super":
                return new SuperRobot();
            case "power":
                return new PowerRobot();
            default:
                return null;
        }
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        RobotFactory robotFactory = new SuperRobotFactory();
        Robot robot1 = robotFactory.createRobot("super");
        Robot robot2 = robotFactory.createRobot("power");

        System.out.println("robot1.getName() = " + robot1.getName());
        System.out.println("robot2.getName() = " + robot2.getName());
    }
}
