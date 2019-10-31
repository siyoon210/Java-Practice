package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

import uml_for_java_programmers.chapter11_coffemaker.CoffeeMakerAPI;

public class M4ContainmentVessel {
    private final CoffeeMakerAPI api;
    private boolean isBrewing;

    public M4ContainmentVessel(CoffeeMakerAPI api) {
        this.api = api;
        this.isBrewing = false;
    }

    public boolean isReady() {
        int plateStatus = api.getWarmerPlateStatus();
        return plateStatus == api.POT_EMPTY;
    }

    public void start() {
        isBrewing = true;
    }
}
