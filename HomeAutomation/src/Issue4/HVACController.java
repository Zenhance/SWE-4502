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
        stateManager.registerComponent(TemperatureSensor.TEMP_KEY, this::evaluateTemparature);}

        public void evaluateTemparature (String key, Object value){
            if (key.equals(TemperatureSensor.TEMP_KEY)) {
                double temperature = (double) value;
                String mode = (String) stateManager.getState(MODE_KEY);
                if (mode.equals(MODE_OFF)) {
                    if (temperature < targetTemperature - hysteresis) {
                        stateManager.updateState(MODE_KEY, MODE_HEATING);
                        heatingCommand.execute();
                    } else if (temperature > targetTemperature + hysteresis) {
                        stateManager.updateState(MODE_KEY, MODE_COOLING);
                        coolingCommand.execute();
                    }
                } else if (mode.equals(MODE_HEATING)) {
                    if (temperature > targetTemperature) {
                        stateManager.updateState(MODE_KEY, MODE_OFF);
                        stopCommand.execute();
                    }
                } else if (mode.equals(MODE_COOLING)) {
                    if (temperature < targetTemperature) {
                        stateManager.updateState(MODE_KEY, MODE_OFF);
                        stopCommand.execute();
                    }
                }
            }
        }
    }





