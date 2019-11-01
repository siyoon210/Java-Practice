package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

public abstract class UserInterface {
    private HotWaterSource hws;
    private ContainmentVessel cv;
    private boolean isComplete;

    public UserInterface(HotWaterSource hws, ContainmentVessel cv) {
        this.hws = hws;
        this.cv = cv;
        this.isComplete = true;
    }

    public abstract void done();

    public abstract void completeCycle();

    public void complete() {
        this.isComplete = true;
        completeCycle();
    }

    protected void startBrewing() {
        if (hws.isReady() && cv.isReady()) {
            hws.start();
            cv.start();
        }
    }
}
