package uml_for_java_programmers.chapter11_coffemaker;

public interface CoffeeMakerAPI {
    int getWarmerPlateStatus();

    int WARMER_EMPTY = 0;
    int POT_EMPTY = 1;
    int POT_NOT_EMPTY = 2;

    int getBoilerStatus() ;

    int BOILER_EMPTY = 0;
    int BOILER_NOT_EMPTY = 1;

    int getBrewButtonStatus();
    int BREW_BUTTON_PUSHED = 0;
    int BREW_BUTTON_NOT_PUSHED = 1;

    void setBoilerState(int boilerStatus);

    int BOILER_ON = 0;
    int BOILER_OFF = 1;

    void setWarmerState(int warmerState);

    int WARMER_ON = 0;
    int WARMER_OFF = 1;

    void setIndicatorState(int indicatorState);

    int INDICATOR_ON = 0;
    int INDICATOR_OFF = 1;

    void setReliefValveState(int reliefValveState);
    int VALVE_OPEN = 0;
    int VALVE_CLOSED = 1;
}
