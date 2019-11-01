package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

public abstract class ContainmentVessel {
    private final UserInterface ui;
    private final HotWaterSource hws;
    protected boolean isBrewing;
    protected boolean isComplete;

    public ContainmentVessel(UserInterface ui, HotWaterSource hws) {
        this.ui = ui;
        this.hws = hws;
        isBrewing = false;
        isComplete = true;
    }

    public abstract boolean isReady();

    public void start() {
        isBrewing = true;
        isComplete = false;
    }

    public void done() {
        isBrewing = false;
    }

    protected void  declareComplete() {
        isComplete = true;
        ui.complete();
    }

    protected void containerAvailable() {
        hws.resume();
    }

    protected void containerUnavailable() {
        hws.pause();
    }
}
