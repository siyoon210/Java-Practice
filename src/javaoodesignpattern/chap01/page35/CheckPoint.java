package javaoodesignpattern.chap01.page35;

public class CheckPoint {
    abstract class HomeApllicancies{
        private Integer serialNo;
        private String manufacturer;
        private Integer year;

        public abstract void turnOn();

        public abstract void turnOff();
    }

    class Washer extends HomeApllicancies {
        @Override
        public void turnOn() {

        }

        @Override
        public void turnOff() {

        }
    }

    class Freezer extends HomeApllicancies {
        @Override
        public void turnOn() {

        }

        @Override
        public void turnOff() {

        }
    }

    class DishWasher extends HomeApllicancies {
        @Override
        public void turnOn() {
            
        }

        @Override
        public void turnOff() {

        }
    }

}
