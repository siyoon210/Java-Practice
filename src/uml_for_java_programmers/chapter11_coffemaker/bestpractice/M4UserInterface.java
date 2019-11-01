package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

import uml_for_java_programmers.chapter11_coffemaker.CoffeeMakerAPI;

public class M4UserInterface extends UserInterface {
    private final CoffeeMakerAPI api;

    public M4UserInterface(CoffeeMakerAPI api, HotWaterSource hws, ContainmentVessel cv) {
        super(hws, cv);
        this.api = api;
    }

    public void poll() {
        int buttonStatus = api.getBrewButtonStatus();

        if (buttonStatus == api.BREW_BUTTON_PUSHED) {
            startBrewing();
        }
    }

    @Override
    public void done() {
        api.setIndicatorState(api.INDICATOR_ON);
    }

    @Override
    public void completeCycle() {
        api.setIndicatorState(api.INDICATOR_OFF);
    }
}
