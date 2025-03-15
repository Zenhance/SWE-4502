package Issue4;

import Issue1.IComponent;
import Issue1.StateManager;

public class HVACController {

    public static final String MODE_KEY = "hvacMode";
    public static final String MODE_OFF = "OFF";
    public static final String MODE_HEATING = "HEATING";
    public static final String MODE_COOLING = "COOLING";

    private final StateManager stateManager;
    private final HVACCommand heatingCommand;
    private final HVACCommand coolingCommand;
    private final HVACCommand stopCommand;
    private final double targetTemperature;
    private final double hysteresis;

    public HVACController(StateManager stateManager, double targetTemperature, double hysteresis) {
        this.stateManager = stateManager;
        this.heatingCommand = new StartHeatingCommand(stateManager);
        this.coolingCommand = new StartCoolingCommand(stateManager);
        this.stopCommand = new StopHVACCommand(stateManager);
        this.targetTemperature = targetTemperature;
        this.hysteresis = hysteresis;

        stateManager.updateState(MODE_KEY, MODE_OFF);
        stateManager.registerComponent(TemperatureSensor.TEMP_KEY, this::evaluateTemperature);}

    private void evaluateTemperature(String key, Object value) {
        if (value instanceof Double) {
            double temp = (Double) value;
            String currentMode = (String) stateManager.getState(MODE_KEY);

            double coolingThreshold = targetTemperature + hysteresis;
            double heatingThreshold = targetTemperature - hysteresis;

            if (MODE_OFF.equals(currentMode)) {
                if (temp > coolingThreshold) coolingCommand.execute();
                else if (temp < heatingThreshold) heatingCommand.execute();
            } else if (MODE_COOLING.equals(currentMode) && temp <= targetTemperature) {
                stopCommand.execute();
            } else if (MODE_HEATING.equals(currentMode) && temp >= targetTemperature) {
                stopCommand.execute();
            }
        }
    }
    }





