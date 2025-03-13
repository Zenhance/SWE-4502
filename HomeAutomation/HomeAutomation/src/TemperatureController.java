public class TemperatureController implements Observer {
    public double targetTemperature;
    public double hysteresisRange = 0.5;
    public boolean heatingOn;
    public boolean coolingOn;

    public TemperatureController(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    @Override
    public void update(EnvironmentState state) {
        adjustTemperature(state.temperature);
    }

    // Adjust heating or cooling based on current temperature
    public void adjustTemperature(double currentTemperature) {
        if (currentTemperature < targetTemperature - hysteresisRange) {
            turnOnHeating();
            turnOffCooling();
        } else if (currentTemperature > targetTemperature + hysteresisRange) {
            turnOnCooling();
            turnOffHeating();
        } else {
            // Within hysteresis range, no action
            turnOffHeating();
            turnOffCooling();
        }
    }

    public void turnOnHeating() {
        heatingOn = true;
        System.out.println("Heating turned ON.");
    }

    public void turnOffHeating() {
        heatingOn = false;
        System.out.println("Heating turned OFF.");
    }

    public void turnOnCooling() {
        coolingOn = true;
        System.out.println("Cooling turned ON.");
    }

    public void turnOffCooling() {
        coolingOn = false;
        System.out.println("Cooling turned OFF.");
    }
}
