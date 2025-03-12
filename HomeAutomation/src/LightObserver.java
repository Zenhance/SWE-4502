public class LightObserver implements Observer {
    private String lastLightStatus;
    private String lastRoom;

    @Override
    public void update(String message) {
        String[] parts = message.split(",");
        this.lastLightStatus = parts[0];
        this.lastRoom = parts[1];
        System.out.println("Light status in " + lastRoom + ": " + lastLightStatus);
    }

    public String getLastLightStatus() {
        return lastLightStatus;
    }

    public String getLastRoom() {
        return lastRoom;
    }
}
