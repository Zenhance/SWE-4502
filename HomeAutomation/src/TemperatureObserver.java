public class TemperatureObserver implements Observer {
    public boolean isHeating;
    public boolean isCooling;
    public String lastRoom;

    @Override
    public void update(String message) {
        String[] parts = message.split(",");

        if (parts.length != 2) {
            System.err.println("Invalid message format");
            return;
        }

        int currentTemp = Integer.parseInt(parts[0]);
        this.lastRoom = parts[1];
        controlTemperature(currentTemp);
    }

    private void controlTemperature(int currentTemp) {
        int targetTemperature = 22;
        int hysteresis = 2;

        if (currentTemp < targetTemperature - hysteresis) {
            isHeating = true;
            isCooling = false;
            System.out.println("Heating activated in " + lastRoom);
        } else if (currentTemp > targetTemperature + hysteresis) {
            isHeating = false;
            isCooling = true;
            System.out.println("Cooling activated in " + lastRoom);
        } else {
            isHeating = false;
            isCooling = false;
            System.out.println("Temperature is normal in " + lastRoom);
        }
    }
}
