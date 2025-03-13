public class TemperatureController implements IObserver {

    private static final double MIN_TEMP = 18.0;
    private static final double MAX_TEMP = 26.0;
    private double lastStateTemp = 0;
    private String lastAction;

    @Override
    public void update(SystemState state) {
        double currentTemp = Double.parseDouble(state.getStateDescription());
            if (currentTemp < MIN_TEMP) {
                 activateHeating();
                 lastStateTemp = currentTemp;

            } else if (currentTemp > MAX_TEMP) {
                activateCooling();
                lastStateTemp = currentTemp;

            } else {
                lastAction = "Temperature is within acceptable range.";
            }

    }


    private void activateHeating() {
        lastAction = "Temperature is low. Activating heating...";
    }


    private void activateCooling() {
        lastAction = "Temperature is high. Activating cooling...";
    }

    public String getLastAction() {
        return lastAction;
    }
}
