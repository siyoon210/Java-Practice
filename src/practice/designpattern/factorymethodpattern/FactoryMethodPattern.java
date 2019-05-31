package practice.designpattern.factorymethodpattern;

/**
 * <팩토리 메소드 패턴>
 * 팩토리 메소드 패턴은 객체를 생성하여 반환하는 '팩토리 메소드'와 '상속'을 통한 기능 확장 방법을 얘기한다.
 * 어떤 객체를 사용할지는 상위클래스는 모르는 추상클래스의 역할을 하고, 하위클래스에서는 사용할 객체를 생성한다.
 *
 * 참고 : https://jdm.kr/blog/180
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
