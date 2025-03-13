public class TemperatureControl implements Observer {
    private boolean heaterOn = false;
    private boolean acOn = false;

    public void update(EnvironmentState state) {
        Double temp = (Double) state.getState("temperature");

        if (temp != null) {
            if (temp < 18) {
                heaterOn = true;
                acOn = false;
                System.out.println("Turning on heater...");
            } else if (temp > 25) {
                acOn = true;
                heaterOn = false;
                System.out.println("Turning on AC...");
            } else {
                heaterOn = false;
                acOn = false;
            }
        }
    }

    public boolean isHeaterOn() {
        return heaterOn;
    }

    public boolean isAcOn() {
        return acOn;
    }
}
