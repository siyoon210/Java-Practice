package elrisgame;

//요구사항
//앨리스의 처음 키는 100~200cm로 랜덤하게 정해진다. (앨리스의 키는 1보다 작을 수 없다.)
//문의 처음 크기는 40~60cm로 랜덤하게 정해진다. (문의 크기는 불변이다.)
//열쇠의 처음 크기는 10~30cm로 랜덤하게 정해진다. (열쇠의 크기는 불변이다.)
//앨리스가 버섯을 먹으면 10~50cm 랜덤하게 앨리스의 키가 커진다. 버섯은 총 10번 먹을 수 있다.
//앨리스가 케이크를 먹으면 10~50cm 랜덤하게 앨리스의 키가 작아진다. 케이크는 총 10번 먹을 수 있다.
//** 앨리스가 열쇠보다 크고 문보다 작으면 문을 통과할 수 있다. (SUCCESS)**
//플레이어가 버섯과 케이크를 적절히 먹어서 문을 통과할 수있도록 하자. 행동의 횟수를 카운트한다.

import java.util.Scanner;

class Elris {
    private static final int INIT_MIN_HEIGHT = 100;
    private static final int INIT_MAX_HEIGHT = 200;
    private static final int MIN_HEIGHT = 1;
    private final Mushroom mushroom;
    private final Cake cake;
    private final Door door;
    private final Key key;
    private int height;

    Elris(Mushroom mushroom, Cake cake, Door door, Key key) {
        this.mushroom = mushroom;
        this.cake = cake;
        this.door = door;
        this.key = key;
        this.height = RandomUtil.getRandomInt(INIT_MIN_HEIGHT, INIT_MAX_HEIGHT);
    }

    void printHeight() {
        System.out.println("현재 앨리스의 키는 : " + this.height);
    }

    void eatMushroom() {
        if (mushroom.isAvailable()) {
            this.height += mushroom.eat();
            printHeight();
            return;
        }

        System.out.println("버섯은 모두 먹었다.");
    }

    void eatCake() {
        if (cake.isAvailable()) {
            this.height += cake.eat();
            if (this.height < MIN_HEIGHT) {
                this.height = MIN_HEIGHT;
            }
            printHeight();
            return;
        }

        System.out.println("케잌은 모두 먹었다.");
    }

    boolean passDoor() {
        if (door.isSmaller(this.height) && key.isBigger(this.height)) {
            System.out.println("** 앨리스는 문을 통과 했습니다! **");
            return true;
        }

        System.out.println("ㅠㅠ 앨리스는 문을 통과 할 수 없습니다 ㅠㅠ");
        return false;
    }
}

class Door {
    private static final int MIN_HEIGHT = 40;
    private static final int MAX_HEIGHT = 60;

    private final int height;

    void printHeight() {
        System.out.println("Door의 크기 : " + this.height);
    }

    Door() {
        this.height = RandomUtil.getRandomInt(MIN_HEIGHT, MAX_HEIGHT);
    }

    boolean isSmaller(int height) {
        return height < this.height;
    }
}

class Key {
    private static final int MIN_HEIGHT = 10;
    private static final int MAX_HEIGHT = 30;

    private final int height;

    void printHeight() {
        System.out.println("Key의 크기 : " + this.height);
    }

    Key() {
        this.height = RandomUtil.getRandomInt(MIN_HEIGHT, MAX_HEIGHT);
    }

    boolean isBigger(int height) {
        return height > this.height;
    }
}

class Mushroom {
    private static final int MIN = 10;
    private static final int MAX = 30;

    private int capacity;

    Mushroom(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return capacity > 0;
    }

    int eat() {
        capacity--;
        return RandomUtil.getRandomInt(MIN, MAX);
    }
}

class Cake {
    private static final int MIN = 30;
    private static final int MAX = 120;

    private int capacity;

    Cake(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return capacity > 0;
    }

    int eat() {
        capacity--;
        return RandomUtil.getRandomInt(MIN, MAX) * -1;
    }
}

public class ElrisGame {
    public static void main(String[] args) {
        Door door = new Door();
        Key key = new Key();
        Mushroom mushroom = new Mushroom(10);
        Cake cake = new Cake(10);

        Elris elris = new Elris(mushroom, cake, door, key);

        System.out.println("시작");
        door.printHeight();
        key.printHeight();
        elris.printHeight();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.nextLine();

            switch (next) {
                case "end":
                    System.exit(0);
                    break;
                case "eat m":
                    elris.eatMushroom();
                    break;
                case "eat c":
                    elris.eatCake();
                    break;
                case "pass d":
                    if (elris.passDoor()) {
                        System.exit(0);
                    }
                    break;
                case "print h":
                    elris.printHeight();
                    break;
                default:
                    System.out.println("end, eat m, eat c, pass d, print h 중 하나를 입력해라");
            }
        }

    }
}
