package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

import uml_for_java_programmers.chapter11_coffemaker.CoffeeMakerAPI;

public class M4UserInterface extends UserInterface {
    private final CoffeeMakerAPI api;

    public M4UserInterface(CoffeeMakerAPI coffeeMakerAPI) {
        this.api = coffeeMakerAPI;
    }

    public void checkButton() {
        int buttonStatus = api.getBrewButtonStatus();

        if (buttonStatus == api.BREW_BUTTON_PUSHED) {
            startBrewing();
        }
    }
}
