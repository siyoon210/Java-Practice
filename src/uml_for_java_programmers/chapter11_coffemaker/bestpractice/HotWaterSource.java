package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

public abstract class HotWaterSource {
    private final UserInterface ui;
    private final ContainmentVessel cv;
    protected boolean isBrewing;

    public HotWaterSource(UserInterface ui, ContainmentVessel cv) {
        this.ui = ui;
        this.cv = cv;
        this.isBrewing = false;
    }

    public abstract boolean isReady();

    public abstract void startBrewing();

    public abstract void pause();

    public abstract void resume();

    public void start() {
        isBrewing = true;
        startBrewing();
    }

    public void done() {
        isBrewing = false;
    }

    public void declareDone() {
        ui.done();
        cv.done();
        isBrewing = false;
    }
}
