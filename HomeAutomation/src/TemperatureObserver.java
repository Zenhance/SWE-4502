public class TemperatureObserver implements Observer {
    private String lastTemperature;
    private String lastRoom;

    @Override
    public void update(String message) {
        String[] parts = message.split(",");
        this.lastTemperature = parts[0];
        this.lastRoom = parts[1];
        System.out.println("Temperature in " + lastRoom + ": " + lastTemperature);
    }

    public String getLastTemperature() {
        return lastTemperature;
    }

    public String getLastRoom() {
        return lastRoom;
    }
}
