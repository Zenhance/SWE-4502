public class TemperatureControl implements Observer {
    public void update(EnvironmentState state) {
        Double temp = (Double) state.getState("temperature");
        if (temp != null) {
            if (temp < 18) {
                System.out.println("Turning on heater...");
            } else if (temp > 25) {
                System.out.println("Turning on AC...");
            }
        }
    }
}
