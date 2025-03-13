public class TemperatureController implements Observer {
    private double targetTemperature = 22.0;
    private boolean heatingOn;
    private boolean coolingOn;

    // This method will be called when the state changes in EnvironmentState
    @Override
    public void update(String state, Object value) {
        // Check if the value passed is a Double representing the current temperature
        if (value instanceof Double) {
            double currentTemperature = (Double) value;

            // Check whether the current temperature is below, above, or equal to the target temperature
            if (currentTemperature < targetTemperature) {
                heatingOn = true;
                coolingOn = false;
            } else if (currentTemperature > targetTemperature) {
                heatingOn = false;
                coolingOn = true;
            } else {
                heatingOn = false;
                coolingOn = false;
            }
        }
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }
}
