package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

import uml_for_java_programmers.chapter11_coffemaker.CoffeeMakerAPI;

public class M4ContainmentVessel extends ContainmentVessel implements Pollable {
    private final CoffeeMakerAPI api;
    private boolean isBrewing;
    private int lastPotStatus;

    public M4ContainmentVessel(UserInterface ui, HotWaterSource hws, CoffeeMakerAPI api) {
        super(ui, hws);
        this.api = api;
        this.isBrewing = false;
    }

    public boolean isReady() {
        int plateStatus = api.getWarmerPlateStatus();
        return plateStatus == api.POT_EMPTY;
    }

    @Override
    public void poll() {
        int potStatus = api.getWarmerPlateStatus();
        if (potStatus != lastPotStatus) {
            if (isBrewing) {
                handleBrewingEvent(potStatus);
            } else if (isComplete == false) {
                handelIncompleteEvent(potStatus);
            }
            lastPotStatus = potStatus;
        }
    }

    private void handleBrewingEvent(int potStatus) {
        if (potStatus == api.POT_NOT_EMPTY) {
            containerAvailable();
            api.setWarmerState(api.WARMER_ON);
        } else if (potStatus == api.WARMER_EMPTY) {
            containerUnavailable();
            api.setWarmerState(api.WARMER_OFF);
        } else {
            containerAvailable();
            api.setWarmerState(api.WARMER_OFF);
        }
    }

    private void handelIncompleteEvent(int potStatus) {
        if (potStatus == api.POT_NOT_EMPTY) {
            api.setWarmerState(api.WARMER_ON);
        } else if (potStatus == api.WARMER_EMPTY) {
            api.setWarmerState(api.WARMER_OFF);
        } else {
            api.setWarmerState(api.WARMER_OFF);
            declareComplete();
        }
    }

    public void start() {
        isBrewing = true;
    }
}
