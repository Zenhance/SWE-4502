public class TemperatureController implements Observer {
    private double targetTemperature = 22.0;
    private boolean heatingOn = false;
    private boolean coolingOn = false;
    private static final double HYSTERESIS = 1.0; // Prevents rapid switching

    @Override
    public void update(String state, Object value) {
        if (state.equals("TEMPERATURE")) {
            double currentTemp = (Double) value;

            if (currentTemp < targetTemperature - HYSTERESIS) {
                heatingOn = true;
                coolingOn = false;
                System.out.println("TemperatureController: Turning ON heater.");
            } else if (currentTemp > targetTemperature + HYSTERESIS) {
                heatingOn = false;
                coolingOn = true;
                System.out.println("TemperatureController: Turning ON air conditioning.");
            } else {
                heatingOn = false;
                coolingOn = false;
                System.out.println("TemperatureController: System idle.");
            }
        }
    }

    public void setTargetTemperature(double temperature) {
        targetTemperature = temperature;
        System.out.println("TemperatureController: Target temperature set to " + temperature + "°C");
    }
}
