package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

public class UserInterface {
    private HotWaterSource hws;
    private ContainmentVessel cv;

    public void done() {

    }

    public void complete() {

    }

    protected void startBrewing() {
        if (hws.isReady() && cv.isReady()) {
            hws.start();
            cv.start();
        }
    }
}
