public class TemperatureController implements Observer {
    private int currentTemperature;

    @Override
    public void update(EnvironmentalState state) {
        this.currentTemperature = state.getTemperature();
        regulateTemperature();
    }

    private void regulateTemperature() {
        if (currentTemperature < 18) {
            System.out.println("Turning on heater...");
        } else if (currentTemperature > 26) {
            System.out.println("Turning on air conditioning...");
        } else {
            System.out.println("Temperature is optimal.");
        }
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}
