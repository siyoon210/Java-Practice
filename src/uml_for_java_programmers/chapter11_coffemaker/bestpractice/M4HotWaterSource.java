package uml_for_java_programmers.chapter11_coffemaker.bestpractice;

import uml_for_java_programmers.chapter11_coffemaker.CoffeeMakerAPI;

public class M4HotWaterSource extends HotWaterSource implements Pollable{
    private final CoffeeMakerAPI api;

    public M4HotWaterSource(UserInterface ui, ContainmentVessel cv, CoffeeMakerAPI api) {
        super(ui, cv);
        this.api = api;
    }

    @Override
    public void startBrewing() {
        api.setReliefValveState(api.VALVE_CLOSED);
        api.setBoilerState(api.BOILER_ON);
    }

    @Override
    public void poll() {
        int boilerStatus = api.getBoilerStatus();
        if (isBrewing) {
            if (boilerStatus == api.BOILER_EMPTY) {
                api.setBoilerState(api.BOILER_OFF);
                api.setReliefValveState(api.VALVE_CLOSED);
                declareDone();
            }
        }
    }

    @Override
    public void pause() {
        api.setBoilerState(api.BOILER_OFF);
        api.setReliefValveState(api.VALVE_OPEN);
    }

    @Override
    public void resume() {
        api.setBoilerState(api.BOILER_ON);
        api.setReliefValveState(api.VALVE_CLOSED);
    }


    public boolean isReady() {
        int boilerStatus = api.getBoilerStatus();
        return boilerStatus == api.BOILER_NOT_EMPTY;
    }

    public void start() {
        api.setReliefValveState(api.VALVE_CLOSED);
        api.setBoilerState(api.BOILER_ON);
    }
}
